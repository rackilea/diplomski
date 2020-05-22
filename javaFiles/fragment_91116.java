char[] code = {'0', '0', '0'};
    if (param1 != null) code[0] = '1';
    if (param2 != null) code[1] = '1';
    if (param3 != null) code[2] = '1';

    String codeString = String.copyValueOf(code);
    switch (codeString) {
      case "000":
        //all are null
        break;
      case "100":
        //param1 is not null
      ...

    }