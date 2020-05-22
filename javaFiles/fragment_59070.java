String text="+919913623683,,,,1,2,,,4328798712363938,,,,5673,,7,8";
System.out.println(
    text
    //           | not preceded by digit
    //           |      | 4 digits
    //           |      |      | not followed by digit
    //           |      |      |         | replace with literal ****
    .replaceAll("(?<=\\D)\\d{4}(?=\\D)", "****")
    //           | 12 digits
    //           |      | followed by 4 digits
    //           |      |            | replace with literal 12 *s
    .replaceAll("\\d{12}(?=\\d{4})", "************")
);