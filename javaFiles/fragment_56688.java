@Override
public int compareTo(DownloadFile downloadFile) {
    String thisStr = this.filename.toLowerCase();
    String oStr = downloadFile.getFilename().toLowerCase();
    List<Predicate<String>> conditionList = new ArrayList<>();
    conditionList.add(s -> s.endsWith(".rar"));
    conditionList.add(s -> s.matches(".*\\.r[0-9]{2,}$"));
    conditionList.add(s -> s.endsWith(".par2"));
    for(Predicate<String> condition : conditionList) {
        int orderForCondition =
                conditionHelper(thisStr, oStr, condition);
        if(orderForCondition != 0)
            return orderForCondition;
    }
    return thisStr.compareTo(oStr);
}

private int conditionHelper(String firstStr, String secondStr,
                            Predicate<String> condition) {
    if(condition.test(firstStr))
        if(!condition.test(secondStr))
            return -1;
    if(condition.test(secondStr))
        if(!condition.test(firstStr))
            return 1;
    return 0;
}