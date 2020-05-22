/**
 * Removes this task from the executor's internal queue if it is
 * present, thus causing it not to be run if it has not already
 * started.
 *
 * <p> This method may be useful as one part of a cancellation
 * scheme.  It may fail to remove tasks that have been converted
 * into other forms before being placed on the internal queue. For
 * example, a task entered using {@code submit} might be
 * converted into a form that maintains {@code Future} status.
 * However, in such cases, method {@link #purge} may be used to
 * remove those Futures that have been cancelled.
 *
 * @param task the task to remove
 * @return true if the task was removed
 */