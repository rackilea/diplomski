public static List<String> splitOnNotNestedCommas(String data){
    List<String> resultList = new ArrayList();

    StringBuilder sb = new StringBuilder();
    int nestingLvl = 0;
    for (char ch : data.toCharArray()){
        if (ch == '(') nestingLvl++;
        if (ch == ')') nestingLvl--;
        if (ch == ',' & nestingLvl==0){
            resultList.add(sb.toString().trim());
            sb.delete(0, sb.length());
        }else{
            sb.append(ch);
        }
    }
    if (sb.length()>0)
        resultList.add(sb.toString().trim());

    return resultList;
}