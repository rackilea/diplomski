package test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Line;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;

public class Test {

public static final int CHANNELS = 2;
public static final int SAMPLE_RATE = 48000;
public static final int NUM_PRODUCERS = 10;
public static final int BUFFER_SIZE_FRAMES = 4800;

// generates some random sine wave
public static class ToneGenerator {

    private static final double[] NOTES = {261.63, 311.13, 392.00};
    private static final double[] OCTAVES = {1.0, 2.0, 4.0, 8.0};
    private static final double[] LENGTHS = {0.05, 0.25, 1.0, 2.5, 5.0};

    private double phase;
    private int framesProcessed;
    private final double length;
    private final double frequency;

    public ToneGenerator() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        length = LENGTHS[rand.nextInt(LENGTHS.length)];
        frequency = NOTES[rand.nextInt(NOTES.length)] * OCTAVES[rand.nextInt(OCTAVES.length)];
    }

    // make sound
    public void fill(short[] block) {
        for (int f = 0; f < block.length / CHANNELS; f++) {
            double sample = Math.sin(phase * 2.0 * Math.PI);
            for (int c = 0; c < CHANNELS; c++)
                block[f * CHANNELS + c] = (short) (sample * Short.MAX_VALUE);
            phase += frequency / SAMPLE_RATE;
        }
        framesProcessed += block.length / CHANNELS;
    }

    // true if length of tone has been generated
    public boolean done() {
        return framesProcessed >= length * SAMPLE_RATE;
    }
}

// dummy audio producer, based on sinewave generator
// above but could also be incoming network packets
public static class AudioProducer {

    final Thread thread;
    final AudioConsumer consumer;
    final short[] buffer = new short[BUFFER_SIZE_FRAMES * CHANNELS];

    public AudioProducer(AudioConsumer consumer) {
        this.consumer = consumer;
        thread = new Thread(() -> run());
        thread.setDaemon(true);
    }

    public void start() {
        thread.start();
    }

    // repeatedly play random sine and sleep for some time
    void run() {
        try {
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            while (true) {
                long pos = consumer.position();
                ToneGenerator g = new ToneGenerator();

                // if we schedule at current buffer position, first part of the tone will be
                // missed so have tone start somewhere in the middle of the next buffer
                pos += BUFFER_SIZE_FRAMES + rand.nextInt(BUFFER_SIZE_FRAMES);
                while (!g.done()) {
                    g.fill(buffer);
                    consumer.mix(pos, buffer);
                    pos += BUFFER_SIZE_FRAMES;

                    // we can generate audio faster than it's played
                    // sleep a while to compensate - this more closely
                    // corresponds to playing audio coming in over the network
                    double bufferLengthMillis = BUFFER_SIZE_FRAMES * 1000.0 / SAMPLE_RATE;
                    Thread.sleep((int) (bufferLengthMillis * 0.9));
                }

                // sleep a while in between tones
                Thread.sleep(1000 + rand.nextInt(2000));
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            t.printStackTrace();
        }
    }
}

// audio consumer - plays continuously on a background
// thread, allows audio to be mixed in from arbitrary threads
public static class AudioConsumer {

    // audio block with "when to play" tag
    private static class QueuedBlock {

        final long when;
        final short[] data;

        public QueuedBlock(long when, short[] data) {
            this.when = when;
            this.data = data;
        }
    }

    // need not normally be so low but in this example
    // we're mixing down a bunch of full scale sinewaves
    private static final double MIXDOWN_VOLUME = 1.0 / NUM_PRODUCERS;

    private final List<QueuedBlock> finished = new ArrayList<>();
    private final short[] mixBuffer = new short[BUFFER_SIZE_FRAMES * CHANNELS];
    private final byte[] audioBuffer = new byte[BUFFER_SIZE_FRAMES * CHANNELS * 2];

    private final Thread thread;
    private final AtomicLong position = new AtomicLong();
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final ConcurrentLinkedQueue<QueuedBlock> scheduledBlocks = new ConcurrentLinkedQueue<>();


    public AudioConsumer() {
        thread = new Thread(() -> run());
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        running.set(false);
    }

    // gets the play cursor. note - this is not accurate and 
    // must only be used to schedule blocks relative to other blocks
    // (e.g., for splitting up continuous sounds into multiple blocks)
    public long position() {
        return position.get();
    }

    // put copy of audio block into queue so we don't
    // have to worry about caller messing with it afterwards
    public void mix(long when, short[] block) {
        scheduledBlocks.add(new QueuedBlock(when, Arrays.copyOf(block, block.length)));
    }

    // better hope mixer 0, line 0 is output
    private void run() {
        Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
        try (Mixer mixer = AudioSystem.getMixer(mixerInfo[0])) {
            Line.Info[] lineInfo = mixer.getSourceLineInfo();
            try (SourceDataLine line = (SourceDataLine) mixer.getLine(lineInfo[0])) {
                line.open(new AudioFormat(SAMPLE_RATE, 16, CHANNELS, true, false), BUFFER_SIZE_FRAMES);
                line.start();
                while (running.get())
                    processSingleBuffer(line);
                line.stop();
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            t.printStackTrace();
        }
    }

    // mix down single buffer and offer to the audio device
    private void processSingleBuffer(SourceDataLine line) {

        Arrays.fill(mixBuffer, (short) 0);
        long bufferStartAt = position.get();

        // mixdown audio blocks
        for (QueuedBlock block : scheduledBlocks) {

            int blockFrames = block.data.length / CHANNELS;

            // block fully played - mark for deletion
            if (block.when + blockFrames <= bufferStartAt) {
                finished.add(block);
                continue;
            }

            // block starts after end of current buffer
            if (bufferStartAt + BUFFER_SIZE_FRAMES <= block.when)
                continue;

            // mix in part of the block which overlaps current buffer
            // note that block may have already started in the past
            // but extends into the current buffer, or that it starts
            // in the future but before the end of the current buffer
            int blockOffset = Math.max(0, (int) (bufferStartAt - block.when));
            int blockMaxFrames = blockFrames - blockOffset;
            int bufferOffset = Math.max(0, (int) (block.when - bufferStartAt));
            int bufferMaxFrames = BUFFER_SIZE_FRAMES - bufferOffset;
            for (int f = 0; f < blockMaxFrames && f < bufferMaxFrames; f++)
                for (int c = 0; c < CHANNELS; c++) {
                    int bufferIndex = (bufferOffset + f) * CHANNELS + c;
                    int blockIndex = (blockOffset + f) * CHANNELS + c;
                    mixBuffer[bufferIndex] += (short) (block.data[blockIndex] * MIXDOWN_VOLUME);
                }
        }

        scheduledBlocks.removeAll(finished);
        finished.clear();
        ByteBuffer.wrap(audioBuffer).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(mixBuffer);
        line.write(audioBuffer, 0, audioBuffer.length);
        position.addAndGet(BUFFER_SIZE_FRAMES);
    }
}

public static void main(String[] args) {

    System.out.print("Press return to exit...");
    AudioConsumer consumer = new AudioConsumer();
    consumer.start();
    for (int i = 0; i < NUM_PRODUCERS; i++)
        new AudioProducer(consumer).start();
    System.console().readLine();
    consumer.stop();
}
}