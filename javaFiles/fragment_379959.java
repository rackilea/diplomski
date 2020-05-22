Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");
    String text = "reciproc(2.00000000000)";
    Matcher m = p.matcher(text);
    if(m.find())
    {
        System.out.println(Double.parseDouble(text.substring(m.start(), m.end())));
    }