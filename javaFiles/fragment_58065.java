Printer printer;

void setPrinter(Printer printer) {
  this.printer = printer;
}

void draw(){
  printer.print("in draw");
}