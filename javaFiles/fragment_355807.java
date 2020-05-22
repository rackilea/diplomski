String regex = "(?<=[\\d])(,)(?=[\\d])";
        Pattern p = Pattern.compile(regex);
        System.out.println("Value?: ");
            Scanner scanIn = new Scanner(System.in);
            String str = scanIn.next();
        Matcher m = p.matcher(str);
        str = m.replaceAll("");
        System.out.println(str);