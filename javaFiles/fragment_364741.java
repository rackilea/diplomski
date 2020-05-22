public static List<String> chunk(String s, int limit) 
{
    List<String> parts = new ArrayList<String>();
    while(s.length() > limit)
    {
        int splitAt = limit-1;
        for(;splitAt>0 && !Character.isWhitespace(s.charAt(splitAt)); splitAt--);           
        if(splitAt == 0) 
            return parts; // can't be split
        parts.add(s.substring(0, splitAt));
        s = s.substring(splitAt+1);
    }
    parts.add(s);
    return parts;
}