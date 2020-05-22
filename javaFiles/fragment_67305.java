/**
 * The throwable that caused this throwable to get thrown, or null if this
 * throwable was not caused by another throwable, or if the causative
 * throwable is unknown.  If this field is equal to this throwable itself,
 * it indicates that the cause of this throwable has not yet been
 * initialized.
 *
 * @serial
 * @since 1.4
 */
private Throwable cause = this;