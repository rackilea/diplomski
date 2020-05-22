/**
 * Public setter for the {@link Sleeper} strategy.
 * @param sleeper the sleeper to set defaults to {@link ThreadWaitSleeper}.
 */
public void setSleeper(Sleeper sleeper) {
    this.sleeper = sleeper;
}