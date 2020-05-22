String input = "Name:\"John Adam\"  languge:\"english\"  Date:\" August 2011\"";
    // You can define this pattern statically.
    Pattern pattern = Pattern.compile("(.*?\\:\\\".*?\\\")\\s*");
    Matcher matcher = pattern.matcher(input);
    List<String> keyValues = new LinkedList<String>();
    while(matcher.find()){
        keyValues.add(matcher.group());
    }

    //keyValues == [Name:"John Adam"  , languge:"english"  , Date:" August 2011"]