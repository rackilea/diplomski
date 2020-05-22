public List<String> splitRight(String string, String regex, int limit) {
    List<String> result = new ArrayList<String>();
    String[] temp = new String[0];
    for(int i = 1; i < limit; i++) {
        if(string.matches(".*"+regex+".*")) {
            temp = string.split(modifyRegex(regex));
            result.add(temp[1]);
            string = temp[0];
        }
    }
    if(temp.length>0) { 
        result.add(temp[0]);
    }
    Collections.reverse(result);
    return result;
}

public String modifyRegex(String regex){
    return regex + "(?!.*" + regex + ".*$)";
}