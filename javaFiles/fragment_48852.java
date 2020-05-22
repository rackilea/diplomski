String a = "abc1_xyz1";

    for (String s : a.split("" +
        "(?<=[a-z])(?=\\d)" +    // space between letter and digit
        "|(?<=\\d)(?=[a-z])" +   // space between digit and letter
        "|(?<=_)(?=\\d)" +       // space between _ and digit
        "|(?<=\\d)(?=_)" +       // space between digit and _
        "|(?<=_)(?=[a-z])" +     // space between _ and letter
        "|(?<=[a-z])(?=_)" +     // space between letter and _
        "")) {
        System.out.println(s);
    }