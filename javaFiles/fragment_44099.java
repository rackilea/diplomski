JAVACODE
void error_skipto(int kind) {
  ParseException e = generateParseException();  // generate the exception object.
  System.out.println(e.toString());  // print the error message
  Token t;
  do {
    t = getNextToken();
  } while (t.kind != kind);
}