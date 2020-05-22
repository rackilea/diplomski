salam package cruft;

/**
 * BadRef description here
 * @author Michael
 * @link
 * @since 6/25/12 5:53 PM
 */
public class BadRef {

    public static void main(String[] args) {
        ref2 buffer[] =  new ref2[255];
        for (int i = 0; i < 255; ++i) {
            buffer[i] = new ref2();