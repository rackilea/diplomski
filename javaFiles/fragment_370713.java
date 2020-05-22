String input = "Your verification Code is aBc123 This Code Valied for 30 Minutes";
    Matcher m1 = Pattern.compile("^Your verification Code is (.*) This Code Valied for (.*)$").matcher(input);
    if(m1.find()) {
        String _code = m1.group(1); // aBc123
        String _minutes  = m1.group(2); // 30 Minutes
        System.out.println("Code is : "+_code);
        System.out.println("Minutes is : "+_minutes);

    }