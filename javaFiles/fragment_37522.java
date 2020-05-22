public class Track {

private static Logger log = LoggerFactory.getLogger(Track.class);

private final long id = System.nanoTime();

// number of channels
private int channelCount;

// maximum seconds to buffer
private int bufferedSeconds = 5;

private AtomicInteger count = new AtomicInteger(0);

private ReentrantLock lock;

private volatile short[] buffer;

private int capacity = 0;

private int head = 0;

private int tail = 0;

public Track(int samplingRate, int channelCount) {
    // set the number of channels
    this.channelCount = channelCount;
    // size the buffer
    capacity = (samplingRate * channelCount) * bufferedSeconds;
    buffer = new short[capacity];
    // use a "fair" lock
    lock = new ReentrantLock(true);
}

/**
 * Returns the number of samples currently in the buffer.
 * 
 * @return
 */
public int getSamplesCount() {
    int i = count.get();
    return i > 0 ? i / channelCount : 0;
}

/**
 * Removes and returns the next sample in the buffer.
 * 
 * @return single sample or null if a buffer underflow occurs
 */
public Short remove() {
    Short sample = null;
    if (count.get() > 0) {
        // decrement sample counter
        count.addAndGet(-1);
        // reposition the head
        head = (head + 1) % capacity;
        // get the sample at the head
        sample = buffer[head];
    } else {
        log.debug("Buffer underflow");
    }
    return sample;
}

/**
 * Adds a sample to the buffer.
 * 
 * @param sample
 * @return true if added successfully and false otherwise
 */
public boolean add(short sample) {
    boolean result = false;
    if ((count.get() + 1) < capacity) {
        // increment sample counter
        count.addAndGet(1);
        // reposition the tail
        tail = (tail + 1) % capacity;
        // add the sample to the tail
        buffer[tail] = sample;
        // added!
        result = true;
    } else {
        log.debug("Buffer overflow");
    }
    return result;
}

/**
 * Offers the samples for addition to the buffer, if there is enough capacity to 
 * contain them they will be added.
 * 
 * @param samples
 * @return true if the samples can be added and false otherwise
 */
public boolean offer(short[] samples) {
    boolean result = false;
    if ((count.get() + samples.length) <= capacity) {
        pushSamples(samples);
        result = true;
    }
    return result;
}

/**
 * Adds an array of samples to the buffer.
 * 
 * @param samples
 */
public void pushSamples(short[] samples) {
    log.trace("[{}] pushSamples - count: {}", id, samples.length);
    try {
        lock.tryLock(10, TimeUnit.MILLISECONDS);
        for (short sample : samples) {
            log.trace("Position at write: {}", tail);
            if (!add(sample)) {
                log.warn("Sample could not be added");
                break;
            }
        }
    } catch (InterruptedException e) {
        log.warn("Exception getting samples", e);
    } finally {
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}

/**
 * Returns a single from the buffer.
 * 
 * @return
 */
public Short popSample(int channel) {
    log.trace("[{}] popSample - channel: {}", id, channel);
    Short sample = null;
    if (channel < channelCount) {
        log.trace("Position at read: {}", head);
        try {
            lock.tryLock(10, TimeUnit.MILLISECONDS);
            sample = remove();
        } catch (InterruptedException e) {
            log.warn("Exception getting sample", e);
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
    return sample;
}