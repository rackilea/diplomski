/**
 * Returns the maximum amount of memory that the Java virtual machine
 * will attempt to use.  If there is no inherent limit then the value
 * {@link java.lang.Long#MAX_VALUE} will be returned.
 *
 * @return  the maximum amount of memory that the virtual machine will
 *          attempt to use, measured in bytes
 * @since 1.4
 */
public native long maxMemory();