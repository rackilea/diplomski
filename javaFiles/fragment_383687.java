public static String removeDups(String s)
{
    if ( s.length() <= 1 ) return s;
    if( s.substring(0,s.length()-1).contains(s.substring(s.length()-1,s.length())) ) return removeDups(s.substring(0,s.length()-1));
    else return removeDups(s.substring(0,s.length()-1)) + s.substring(s.length()-1,s.length());
}


INPUT: "AAAABBARRRCC"
OUTPUT: "ABRC"