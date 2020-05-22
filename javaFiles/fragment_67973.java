for(Element e : Phone_Num)
{
    Matcher matcher = pattern.matcher(e.text());
    if (matcher.find()) {
        PNUM += matcher.group(0).trim() + " & "; // store all phone number seperated by &
    }
}