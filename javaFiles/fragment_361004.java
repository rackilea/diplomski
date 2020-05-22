String encode(String in, String replacements)
{
    StringBuilder out = new StringBuilder();
    for(char c : in.toCharArray())
        out.append(replacements.charAt(c - 'a')); //can swap replacements with an array/ArrayList: replacements[c - 'a'] and replacements.get(c - 'a'a)
    return out.toString();
}