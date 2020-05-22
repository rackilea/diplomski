String test = "hello world this is example";
        Pattern p = Pattern.compile("(?<=.{15}).");

        Matcher m=p.matcher(test);
        m.find();
        System.out.println(m.start());