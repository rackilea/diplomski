String str2 = str1
      .replaceAll("([0-9])(?=[A-Z])", "$1 ")                 //1
      .replaceAll("\\bAND\\b", "&")                          //2
      .replaceAll("\\bOR\\b", "|")                           //3
      .replaceAll("(?<![=<>!])=(?!=)", "==")                 //4
      .replaceAll("<>", "!=")                                //5
      .replaceAll("(?<=[^&| ])(==|!=|&|\\)|\\|)", " $1")     //6
      .replaceAll("(==|!=|&|\\(|\\)|\\|)(?=[^ &|])", "$1 "); //7