/**
 * Determine the next execution time according to the given trigger context.
 * <p>Next execution times are calculated based on the
 * {@linkplain TriggerContext#lastCompletionTime completion time} of the
 * previous execution; therefore, overlapping executions won't occur.
 */