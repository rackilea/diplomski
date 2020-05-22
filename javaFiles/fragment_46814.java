public class PrintableWrapper implements Printable {
private Printable delegate;
private int offset;

public PrintableWrapper(Printable delegate, int offset) {
    this.offset = offset;
    this.delegate = delegate;
}

@Override
public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
    return delegate.print(graphics, pageFormat, pageIndex-offset);
}}