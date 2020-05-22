/**
 * Setter for maximum back off period. Default is 30000 (30 seconds). the
 * value will be reset to 1 if this method is called with a value less than
 * 1. Set this to avoid infinite waits if backing off a large number of
 * times (or if the multiplier is set too high).
 *
 * @param maxInterval in milliseconds.
 */
public void setMaxInterval(long maxInterval) {
    this.maxInterval = maxInterval > 0 ? maxInterval : 1;
}