public static int count(String str, char a) {
    int exist = str.indexOf(a);
    if ( <a doesn't exist in str*> )
        return 0;
    else {   /* recur on the rest of the string; add 1 */
        rest = str.substr(exist+1, <end of string>)
        return count(rest, a) + 1
    }
}