System.out.println(Arrays.toString(new boolean[] {
            "###  hey  ###".matches(".*\\s{2}\\w+\\s{2}.*"),
            "###  tût  ###".matches(".*\\s{2}\\w+\\s{2}.*"),
            "###  لتَّيْم  ###".matches(".*\\s{2}\\w+\\s{2}.*"),
            "###  لتَّيْم  ###".matches(".*\\s{2}\\p{InArabic}+\\s{2}.*")
    }));
    Matcher matcher = Pattern.compile("\\s\\x{200f}(\\p{InArabic}+)\\s\\x{200f}").matcher(getText());
    while (matcher.find()) {
        System.out.println(matcher.group(1));
    }