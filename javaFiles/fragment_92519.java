public static void main(String[] args) {
    List<String> list = Arrays.asList("https://share.host.com/",
            "https://media.host.com/","https://lost.host.com/","https://anything.google.in/","https://found.host.com/","https://anything.host.com/","https://anything.host.in.com/");

    String regEx="https://[\\w]+[.]host[.]com/";

    for(String input:list) {
        Matcher matcher = Pattern.compile(regEx).matcher(input);            

        if(matcher.matches()) {         
            System.out.println("Valid   :" +input );
        }else {
            System.out.println("Invalid :" +input);
        }
    }
}