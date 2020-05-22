boolean compareStrings(String str1, String str2) {
    if (str1.length() != str2.length())
        return false;
    int differences = 0;
    for (int i = 0; i < str1.length(); i++) {
        if(str1.charAt(i) != str2.charAt(i))
            if(++differences > 1)
                return false;
    }
    //if the execution is here, then there are 0, or 1 differences, so return true
    return true;
}