byte len = Byte.MIN_VALUE;  //This value is for dummy assignment
try {
     len = (byte) passLength();
} catch(Exception inputMismatchException) { // Avoid using variable name starts with Capitals
     System.out.println("Error, please input a proper number");
} finally {
     String result = passGen(len, chars);
     System.out.println(result);
}