public static void main(String[] args) {
        String input="{a c df sdf TDUS^&%^7 }";     
        String regEx="(.*[{]{1})(.*)([}]{1})";
        Matcher matcher = Pattern.compile(regEx).matcher(input);            

        if(matcher.matches()) {         
            System.out.println(matcher.group(2));
        }
}