import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.Global;
import com.xuggle.xuggler.IAudioSamples;
import com.xuggle.xuggler.IContainer;
import com.xuggle.xuggler.IPacket;
import com.xuggle.xuggler.IStreamCoder;
import com.xuggle.xuggler.IVideoPicture;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Pasban
 */
public class MergeVideoAudio extends JDialog {

    Image image;
    private double video_duration = 0.00001, video_read = 0, audio_duration = 0.00001, audio_read = 0;

    public static void main(String[] args) {
        final MergeVideoAudio merge = new MergeVideoAudio();
        Thread thread = new Thread() {

            @Override
            public void run() {
                merge.perform("y:/a.mp4", "y:/b.mp3", "y:/c.mp4");
                merge.setVisible(false);
                System.exit(0);
            }
        };
        thread.run();
    }

    public void perform(String path_video, String path_audio, String path_output) {

        IMediaWriter mWriter = ToolFactory.makeWriter(path_output);
        IContainer containerVideo = IContainer.make();
        IContainer containerAudio = IContainer.make();

// check files are readable
        if (containerVideo.open(path_video, IContainer.Type.READ, null) < 0) {
            throw new IllegalArgumentException("Cant find " + path_video);
        }

        if (containerAudio.open(path_audio, IContainer.Type.READ, null) < 0) {
            throw new IllegalArgumentException("Cant find " + path_audio);
        }

// read video file and create stream
        IStreamCoder coderVideo = containerVideo.getStream(0).getStreamCoder();

        if (coderVideo.open(null, null) < 0) {
            throw new RuntimeException("Cant open video coder");
        }
        int width = coderVideo.getWidth();
        int height = coderVideo.getHeight();

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

// read audio file and create stream
        IStreamCoder coderAudio = containerAudio.getStream(0).getStreamCoder();

        if (coderAudio.open(null, null) < 0) {
            throw new RuntimeException("Cant open audio coder");
        }

        IPacket packet = IPacket.make();

        mWriter.addAudioStream(1, 0, coderAudio.getChannels(), coderAudio.getSampleRate());
        mWriter.addVideoStream(0, 0, width, height);

        video_duration = 0.000001 + (containerVideo.getDuration() == Global.NO_PTS ? 0 : (containerVideo.getDuration() / 1000.0));
        audio_duration = 0.000001 + (containerAudio.getDuration() == Global.NO_PTS ? 0 : (containerAudio.getDuration() / 1000.0));

        while (containerVideo.readNextPacket(packet) >= 0) {
            video_read = (packet.getTimeStamp() * packet.getTimeBase().getDouble() * 1000);

// video packet
            IVideoPicture picture = IVideoPicture.make(coderVideo.getPixelType(), width, height);
            coderVideo.decodeVideo(picture, packet, 0);
            if (picture.isComplete()) {
                mWriter.encodeVideo(0, picture);
                IConverter converter = ConverterFactory.createConverter(ConverterFactory.XUGGLER_BGR_24, picture);
                this.setImage(converter.toImage(picture));
                this.setProgress(video_duration, video_read, audio_duration, audio_read);
            }

// audio packet 
            containerAudio.readNextPacket(packet);
            audio_read = (packet.getTimeStamp() * packet.getTimeBase().getDouble() * 1000);
            IAudioSamples samples = IAudioSamples.make(512, coderAudio.getChannels(), IAudioSamples.Format.FMT_S32);
            coderAudio.decodeAudio(samples, packet, 0);
            if (samples.isComplete()) {
                mWriter.encodeAudio(1, samples);
                this.setProgress(video_duration, video_read, audio_duration, audio_read);
            }

        }

//write the remaining audio, if your audio is longer than your video
        while (containerAudio.readNextPacket(packet) >= 0) {
            audio_read = (packet.getTimeStamp() * packet.getTimeBase().getDouble() * 1000);
            IAudioSamples samples = IAudioSamples.make(512, coderAudio.getChannels(), IAudioSamples.Format.FMT_S32);
            coderAudio.decodeAudio(samples, packet, 0);
            if (samples.isComplete()) {
                mWriter.encodeAudio(1, samples);
                this.setProgress(video_duration, video_read, audio_duration, audio_read);
            }
        }

        coderAudio.close();
        coderVideo.close();
        containerAudio.close();
        containerVideo.close();

        mWriter.close();
    }

    public MergeVideoAudio() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void setImage(final Image image) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MergeVideoAudio.this.image = image;
                repaint();
            }
        });
    }

    @Override
    public synchronized void paint(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }

    public static String convertDurationHMSm(double time) {
        long elapsed = (long) (time * 1000);
        long duration = elapsed / 1000;
        long ms = elapsed % 1000;
        return String.format("%02d:%02d:%02d.%02d", duration / 3600, (duration % 3600) / 60, (duration % 60), ms / 10);
    }

    private void setProgress(double video_duration, double video_read, double audio_duration, double audio_read) {
        this.setTitle("Video: " + (int) (100 * video_read / video_duration) + "%, Audio " + (int) (100 * audio_read / audio_duration) + "%");
    }
}