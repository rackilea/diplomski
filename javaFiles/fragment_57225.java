/**
 * Prints a String and then terminates the line.  This method behaves as
 * though it invokes <code>{@link #print(String)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x the <code>String</code> value to be printed
 */
public void println(String x) {
    synchronized (lock) {
        print(x);
        println();
    }
}