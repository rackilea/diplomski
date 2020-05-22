/**
  * Parses the given input as a Windows path.
  * 
  * @param   input - 1st case: '/\home\cay' ; 2nd case: 'myprog\conf\user.properties'
  * @param   requireToNormalize - true for both cases
  */
private static Result parse(String input, boolean requireToNormalize) {
  String root = "";
  WindowsPathType type = null;

  int len = input.length(); // 1st case: len = 10 , 2nd case: len = 27
  int off = 0;
  if (len > 1) {
    char c0 = input.charAt(0); // 1st case: c0 = '/' , 2nd case: c0 = 'm'
    char c1 = input.charAt(1); // 1st case: c1 = '\' , 2nd case: c1 = 'y'
    int next = 2;
    if (isSlash(c0) && isSlash(c1)) // this condition is true ONLY for 1st case
    {
       type = WindowsPathType.UNC;
       off = nextNonSlash(input, next, len); // 1st case: off = 2
       next = nextSlash(input, off, len);    // 1st case: next = 6
       if (off == next)
         throw new InvalidPathException(input, "UNC path is missing hostname");

       String host = input.substring(off, next); // 1st case: host = home
       off = nextNonSlash(input, next, len);     // 1st case: off = 7
       next = nextSlash(input, off, len);        // 1st case: next = 10
       if (off == next)
         throw new InvalidPathException(input, "UNC path is missing sharename");

       root = "\\\\" + host + "\\" + input.substring(off, next) + "\\"; // 1st case: root = \\home\cay\
       off = next; // 1st case: off = next = 10
    } else {
      if (isLetter(c0) && c1 == ':') { // this condition is false for 2nd case
        ...
      }
    }
 }
 if (off == 0) { // 1st case: off = 10, 2nd case: off = 0
    if (len > 0 && isSlash(input.charAt(0))) { // 2nd case: false
      type = WindowsPathType.DIRECTORY_RELATIVE;
      root = "\\";
    } else {
       type = WindowsPathType.RELATIVE;
    }
  }

  if (requireToNormalize) { // true for both cases
    StringBuilder sb = new StringBuilder(input.length());
    sb.append(root);
    /* 
      1st case: type = UNC, root = '\\home\cay\' , off = 10 , normalize(...) = '\\home\cay\'
      2nd case: type = RELATIVE, root = '' , off = 0 , normalize(...) = 'myprog\conf\user.properties'
     */
     return new Result(type, root, normalize(sb, input, off));
   } else {
     ...
   }
}

private static final boolean isSlash(char c) {
  return (c == '\\') || (c == '/');
}