try {
        String s = "<strong>Krishna Pujari</strong>";
        Pattern p = Pattern.compile("<strong>(.+?)</strong>");
        Matcher m = p.matcher(s);
        m.find();
        System.out.println(m.group(1));
    } catch (IllegalStateException e) {
        // this wont close your app
    }