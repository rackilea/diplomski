String input = "I have a $personInstance.address, but I like    $personInstance.last_name dog better.";

    Pattern p = Pattern.compile("\\$(\\w+\\.\\w+)");
    Matcher m = p.matcher(input);
    while (m.find()) {
        System.out.println("Found a " + m.group(1));
        //use m.group(0) vs m.group(1) if you want $ to be returned as well
    }