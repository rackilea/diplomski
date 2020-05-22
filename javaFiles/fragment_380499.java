abstract class PrinterDecorator implements Printable {
  private Printable printer;

  public void setDecorator(Printable p) {
    printer = p;
  }

  public void print() {
    if (printer != null)
      printer.print();
  }
}