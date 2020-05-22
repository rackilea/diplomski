public String decode(String input) {
    String[] letters = input.split(" ");
    StringBuilder ret = new StringBuilder();
    for(String s : letters){
                ret.append(decodeMap.get(s));
    }
    return ret.toString();
}