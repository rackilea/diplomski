public void setA(double a) {
  this.a = (isValidA(a)) ? a : 100;
  setC(); // <-- call setC();
}
public void setB(double b) {
  this.b = (isValidB(b)) ? b : -1;
  setC(); // <-- call setC();
}