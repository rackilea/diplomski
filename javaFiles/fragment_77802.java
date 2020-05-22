Pattern p = Pattern.compile("^([0-9_]+v._.).*$");
       String str = "117_117_0009v0_172_5738_5740";

        Matcher m = p.matcher(str);
        if (m.matches())
        {
            System.out.println(m.group(1));
        }