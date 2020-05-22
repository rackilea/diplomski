Pattern pattern = Pattern.compile("([0-9]{2})([0-9]{2})([0-9]{1,})");    
    Matcher matcher = pattern.matcher("1508261");
    ArrayList<String> list = new ArrayList<String>();
    if(matcher.matches()) {
        for(int i = 1;i <= matcher.groupCount();i++)
            list.add(matcher.group(i));
    }

    System.out.println(list);