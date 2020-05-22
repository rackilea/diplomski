package cruft;

/**
 * Board description here
 * @author Michael
 * @link
 * @since 11/26/12 6:46 PM
 */
public class Board {

    public int count;

    public static void main(String[] args) {
        Board b = new Board();
        Board c = b;
        System.out.println("b before: " + b);
        System.out.println("c before: " + c);

        ++b.count;

        System.out.println("b after : " + b);
        System.out.println("c after : " + c);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Board");
        sb.append("{count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}