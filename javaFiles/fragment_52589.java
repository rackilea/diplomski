public String replaceMultipleSubstrings(String original, List<String> mylist){
    String tmp = original;
    for(String str: mylist){
        tmp = tmp.replace(str, "");
    }
    return tmp;
}