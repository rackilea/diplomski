/**
 * Allocates a new {@code String} so that it represents the sequence of
 * characters currently contained in the character array argument. The
 * contents of the character array are copied; subsequent modification of
 * the character array does not affect the newly created string.
 *
 * @param  value
 *         The initial value of the string
 */
public String(char value[]) {
    int size = value.length;
    this.offset = 0;
    this.count = size;
    this.value = Arrays.copyOf(value, size);
}