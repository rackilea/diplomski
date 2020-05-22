String str1 = "This is test 1  .  This is test 2  [2 b]. This is test 3 (3). This is test 4.[4a] This is a test 5 . This is test 6 . (6,six)";

Pattern reg1 = Pattern.compile(" (?<!\\w )(\\w)(?=\\w{2,})");              // Preparation
Pattern regNewline = Pattern.compile("\n");                                // Split
String[] array = regNewline.split(reg1.matcher(str1).replaceAll("\n$1"));  // Apply


Arrays.stream(array).forEach(System.out::println);                         // Test it