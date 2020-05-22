//Deletes all extra occurrences of String x(which can just be a single character)
public static StringBuffer removeDuplicateOf(StringBuffer s, String x){
    while(s.indexOf(x) != s.lastIndexOf(x))
        s.deleteCharAt(s.lastIndexOf(x));
    return s;
}