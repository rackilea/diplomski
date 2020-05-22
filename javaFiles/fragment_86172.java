// Switch-Statement with break
private static String statementBreak(int switchArg){
  String str = "not set";
  switch (switchArg){
    case 1:
    case 2:
      str = "one or two";
      break;
    case 3:
      str = "three";
      break;
  };
  return str;
}