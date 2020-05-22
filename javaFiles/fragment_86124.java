String line = "12 Bob Marley 22/01/15 0 0 1 1 0";

    String pattern = "([0-9]+)([a-zA-z|' ']+)(.*)";

    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(line);

    if(m.find()) {
        System.out.println("No:" + m.group(1));//this will get 12
        System.out.println("ref:" + m.group(2));//this will get the name
        String[] parts = m.group(3).split(" ");//this is the rest
        String date      = parts[0];
        String one       = parts[1];
        String sd        = parts[2];
        String dd        = parts[3];
        String tt        = parts[4];
        String vs        = parts[5];
        System.out.println("Date:"+date+"One:"+one+"Sd:"+sd+"Dd:"+dd+"Tt:"+tt+"Vs:"+vs);
    }