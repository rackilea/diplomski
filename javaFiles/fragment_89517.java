final String number;
{
    final Matcher m = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(input);
    if(m.find())
        number = m.group(); // retrieve the matched substring
    else
        number = null; // no match found
}