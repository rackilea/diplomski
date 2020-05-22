public String[] splitMe(String[] arr){
    ArrayList<String> retList = new ArrayList<String>();
    for(String t:arr){
        String[] splits = t.split("-");
        for(String s: splits){
            retList.add(s);
        }
    }
    return retList.toArray(new String[retList.size()]);
}