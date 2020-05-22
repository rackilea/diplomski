public String getSub(String orig){
    String delim = "^^^^^latency in nano";

    int idx = orig.indexOf(delim);
    if(idx != -1){
       return orig.substring(idx + delim.length());
    }
    return orig; // delim not found.
}