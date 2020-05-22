String encode(String in, ArrayList<String> a, ArrayList<String> b)
{
    StringBuilder out = new StringBuilder();
    for(char c : in.toCharArray())
        out.append(b.get(a.indexOf("" + c))); //should do error checking if the input contains characters not in a
    return out.toString();
}