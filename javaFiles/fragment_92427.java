Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    boolean matches = false;
    do {
        IP = Scr.nextLine();
        Matcher matcher = pattern.matcher(IP);
        matches = matcher.matches();
        if (matches == false)
            System.out.println("wrong range");
        else {
            int number = Integer.parseInt(matcher.group(1));
            System.out.println("first group is " + number);
            if (number < 127)
                System.out.println("Class A");
            else ...
        ...