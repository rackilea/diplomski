/*
 * This avoid creating new fields and uses only the passed parameter.
 * 
 * - First we set the FIRST character of the s value to the LAST
 * character of the parameter;
 * 
 * - Second we concatenate this with a substring from s, which goes
 * from second character to the "semi last" (last previous);
 * 
 * - Then we can add the FIRST character at the END.
 */
public static String swapFirstAndLast(String s) {
    return s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);
}