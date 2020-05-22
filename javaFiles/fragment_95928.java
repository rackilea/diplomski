String pattern = "A\\d{9}|(\\d{3}){3}|A?(\\d{3}-){2}\\d{3}";

    String[] sArr = {"A123456789", "123-456-789", "A123-456-789", "123456789", "qwerty", "12-345-12"};

    Pattern p = Pattern.compile(pattern);
    for (int i = 0; i < sArr.length; i++) {
        Matcher m = p.matcher(sArr[i]);

        if (m.find()) {
            System.out.println("Value Matched :: " + sArr[i]);
        } else {
            System.out.println("Value Not Matched :: " + sArr[i]);

        }
    }