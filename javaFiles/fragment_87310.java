static public String convertCSSFonttoHTML(String css)
{

    List<List<String>> allFontTags = regexFindMultiStrings("<font[^>]*(style=['\"][^'\"]+['\"])[^>]*>", css);
    String allAttributes = "";

    for(int y=0; y<allFontTags.size(); y++)
    {
        String style = allFontTags.get(y).get(0);
        String size = regexFindString("font-size:([^0-9]+)", style);
        String color = regexFindString("color:([^;]+);", style);
        String face = regexFindString("font-family:([^;]+)", style);

        if(!size.isEmpty())
             allAttributes += "size=\""+size+"\" ";

        if(!color.isEmpty())
             allAttributes += "color=\"" + color + "\" ";

        if(!size.isEmpty())
             allAttributes += "face=\""+face+"\"";



        //do replacements to the first occurance
        css = css.replaceFirst(style, allAttributes);

        //empty atts
        allAttributes = "";
    }

    //Log.e("Regex", css);


    return css;

}