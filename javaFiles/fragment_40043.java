/**
 * Parses the string argument as a signed integer in the radix 
 * specified by the second argument. The characters in the string 
 * must all be digits of the specified radix (as determined by 
 * whether {@link java.lang.Character#digit(char, int)} returns a 
 * nonnegative value), except that the first character may be an 
 * ASCII minus sign <code>'-'</code> (<code>'&#92;u002D'</code>) to 
 * indicate a negative value. The resulting integer value is returned. 
 * <p>
 * An exception of type <code>NumberFormatException</code> is
 * thrown if any of the following situations occurs:
 * <ul>
 * <li>The first argument is <code>null</code> or is a string of
 * length zero.
 * <li>The radix is either smaller than 
 * {@link java.lang.Character#MIN_RADIX} or
 * larger than {@link java.lang.Character#MAX_RADIX}. 
 * <li>Any character of the string is not a digit of the specified
 * radix, except that the first character may be a minus sign
 * <code>'-'</code> (<code>'&#92;u002D'</code>) provided that the
 * string is longer than length 1.
 * <li>The value represented by the string is not a value of type
 * <code>int</code>. 
 * </ul><p>
 * Examples:
 * <blockquote><pre>
 * parseInt("0", 10) returns 0
 * parseInt("473", 10) returns 473
 * parseInt("-0", 10) returns 0
 * parseInt("-FF", 16) returns -255
 * parseInt("1100110", 2) returns 102
 * parseInt("2147483647", 10) returns 2147483647
 * parseInt("-2147483648", 10) returns -2147483648
 * parseInt("2147483648", 10) throws a NumberFormatException
 * parseInt("99", 8) throws a NumberFormatException
 * parseInt("Kona", 10) throws a NumberFormatException
 * parseInt("Kona", 27) returns 411787
 * </pre></blockquote>
 *
 * @param      s   the <code>String</code> containing the integer 
 *          representation to be parsed
 * @param      radix   the radix to be used while parsing <code>s</code>.
 * @return     the integer represented by the string argument in the
 *             specified radix.
 * @exception  NumberFormatException if the <code>String</code>
 *         does not contain a parsable <code>int</code>.
 */