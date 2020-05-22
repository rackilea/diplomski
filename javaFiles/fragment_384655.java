String str = "XX123456789123456XX";
    if (str.matches(".*\\d{13}.*")) {
        System.out.println(true);
        Pattern compile = Pattern.compile("\\d+");
        Matcher matcher = compile.matcher(str);
        matcher.find();
        String masked = maskCCNumber(matcher.group());//send 123456789123456 and returns 123456%%%%%3456
        String finalString=str.replaceAll("\\d+", masked);// replace all digits with 123456%%%%%3456
        System.out.println(finalString);

    }