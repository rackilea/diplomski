void setup() {
  org.nfunk.jep.JEP parser = new org.nfunk.jep.JEP();
  parser.addComplex();
  try {
    parser.parseExpression("(1+2*i) + (3+8*i)");
    println(parser.getComplexValue());
  } catch(Exception e) {
    e.printStackTrace();
  }
}