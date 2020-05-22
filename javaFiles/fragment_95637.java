/**
 * Adds two string numbers
 * @param a
 * @param b
 * @return
 * @throws NumberFormatException if either of a or b is not an integer
 */
public static int sum(String a, String b) throws NumberFormatException {
    int x = Integer.parseInt(a); 
    int y = Integer.parseInt(b); 
    return x + y;
}