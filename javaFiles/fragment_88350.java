public class MoveArrayValues
{
    final static String F = "X*", E = "O*";
    final static String X = "X", O = "O";
    final static String B = " ", T = "-";

    final static int COLUMN_COUNT = 5;

    public static void main( String[] args )
    {
        String[] source = 
            { 
                F, O, B, X, E, 
                O, O, B, B, X,
                O, B, X, X, E, 
                X, B, B, X, X, 
                X, X, E, X, E
            };

        // Print the original source
        for ( int ptr = 0; ptr < source.length; ptr++ )
        {
            System.out.print("[" + source[ptr] + "]");
            if ( ptr != 0 && ((ptr + 1) % COLUMN_COUNT) == 0 ) System.out.println();
        }

        // Initialise the target array and then process the source
        String[] target = new String[source.length];
        for ( int ptr = 0; ptr < source.length; ptr++ )
        {
            String cell = source[ptr];
            if ( cell.equals(T) )
            { // Skip cells marked as "taken"
                continue;
            }
            if ( cell.equals(F) || cell.equals(E) )
            { // False values
                target[ptr] = B; // false value becomes a blank

                // now find a new location for this false value
                int offset = 1;
                /*
                 * This while loop will find the closest free cell that
                 * hasn't already been taken (preferring the cell to the
                 * right).
                 * 
                 * The while condition is just to make sure we don't 
                 * fall into an endless loop
                 */
                while ( offset < source.length )
                {
                    if ( ptr + offset < source.length )
                    { // Scan to the right
                        String tmp = source[ptr + offset];
                        if ( tmp.equals(B) )
                        { // found a blank, now use this space
                            source[ptr + offset] = T; // Mark the space as "taken"
                            target[ptr + offset] = cell.equals(F) ? X : O;
                            break;
                        }
                    }
                    if ( ptr - offset >= 0 )
                    { // Scan to the left
                        String tmp = source[ptr - offset];
                        if ( tmp.equals(B) )
                        { // found a blank, now use this space
                            source[ptr - offset] = T; // Mark the space as "taken"
                            target[ptr - offset] = cell.equals(F) ? X : O;
                            break;
                        }
                    }
                    offset++;
                }
            }
            else
            { // Normal values and spaces
                target[ptr] = cell;
            }
        }

        System.out.println("--------------------");
        // Print the resultant target
        for ( int ptr = 0; ptr < target.length; ptr++ )
        {
            System.out.print("[" + target[ptr] + "]");
            if ( ptr != 0 && ((ptr + 1) % COLUMN_COUNT) == 0 ) System.out.println();
        }
    }
}