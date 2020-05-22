/**
 * Replaces the first letter in a {@code String} in O(1) time.
 *
 * This uses reflection to change the values and will modify the
 * {@code String}s values. 
 *
 * @param str the {@code String} to modify.
 * @param letter the new first letter of the {@code String}.
 * @return {@code str}
 */
public static String replaceFirstLetter(String str, char letter) {
    if (str == null) {
        throw new NullPointerException("str cannot be null");
    }

    if (str.length() == 0) {
        throw new IllegalArgumentException("String cannot be empty");
    }

    try {
        Field value
                = str.getClass().getDeclaredField("value");

        value.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(value, value.getModifiers() & ~Modifier.FINAL);

        char[] values = (char[]) value.get(str);
        values[0] = letter;
        value.set(str, values);

    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
        ex.printStackTrace();
        //This should never happen
    }

    return str;
}