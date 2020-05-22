import java.io.PrintStream;

public class UncloseablePrintStream extends PrintStream {
    public UncloseablePrintStream(PrintStream ps) {
        super(ps);
    }

    @Override
    public void close() {
        // Do nothing
    }
}