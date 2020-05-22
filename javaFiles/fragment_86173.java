// Switch-Expression with yield
private static String expressionBreakWithValue(int switchArg){
  return switch (switchArg){
    case 1, 2: yield "one or two";
    case 3: yield "three";
    default: yield "smaller than one or bigger than three";
  };
}