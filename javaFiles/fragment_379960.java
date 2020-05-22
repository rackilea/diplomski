Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");
    Matcher m = p.matcher("reciproc(2.00000000000)");
    if(m.find())
    {
        System.out.println(Double.parseDouble(m.group()));
    }