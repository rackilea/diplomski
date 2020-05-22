public static void main (String[] args) throws java.lang.Exception
{
    System.out.println(parseStringAlias("\"info i = 5,\""));
    System.out.println(parseStringValue("\"info i = 5,\""));
}
//Produces "info i 5" rather than the desired "i"
public static String parseStringAlias(String textToBeParsed)
{
    //Gets the value(or alias) located between the word info and the = sign
    Pattern p = Pattern.compile("info(.*?)="); // <- Note removed `//`
    Matcher m = p.matcher(textToBeParsed);
    //0 would be the first match
    if (m.find()) {                          // < - We "ran" the regex search
        return m.group(1);                   // <- Group 1 is accessed
    }
    return "";
}   

//Returns ImputMismatchException rather than the desired number between equals sign and comma
//If given out example of "info i = 5," should return 5
public static String parseStringValue(String textToBeParsed)
{
    //Pattern fetches the value between the "=" and the ","
    Pattern p = Pattern.compile("(?<==).*?(?=,)");          // <- Note removed `\\` and `//`
    //Search for matches
    Matcher m = p.matcher(textToBeParsed);
    //0 would be the first match
    if (m.find()) {                               // <- We "ran" the regex
        return m.group(0);                       // <- We access 0th group, the whole match
    }
    return "";
}