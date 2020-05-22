Pattern p = Pattern.compile("/drug(/|$)");
    Matcher m = p.matcher(myURLString);
    if(m.find())
    {
        something_to_do
    }