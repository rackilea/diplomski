public static void main(String[] args) {
    String main = "{\"categories\":[\"May\",\"Apr\",\"Mar\"]}";
    String json1 = "{\"categories\":[\"May\",\"May\",\"Apr\",\"Apr\",\"Mar\",\"Mar\"]}";
    String json2 = "{\"categories\":[\"May\",\"Apr\",\"Apr\",\"Mar\",\"Mar\",\"Mar\"]}";
    String json3 = "{\"categories\":[\"May\",\"Apr\",\"Mar\",\"Mar\"]}";

    List<String> mainList = jsonToList(main);

    List<String> list1 = jsonToList(json1);
    List<String> diff1 = diffList(mainList, list1);
    for (String s : diff1) {
        System.out.println(s);
    }

    String view = viewResult(mainList, list1, diff1);
}

private static List<String> jsonToList(String json){
    List<String> list = new ArrayList<String>();
    Gson gson = new Gson();
    Type type = new TypeToken<Map<String, Object>>(){}.getType();
    Map<String, Object> jsonMap = gson.fromJson(json, type);
    Map<String, Object> flatten = FlatMapUtil.flatten(jsonMap);
    flatten.forEach((k, v) -> list.add(v.toString()));
    return list;
}

private static List<String> diffList(List<String> mainList, List<String> secondList){
    List<String> list = new ArrayList<String>();
    Map<String, Integer> wordCount = new HashMap<>();
    for(String word: secondList) {
        if(mainList.contains(word)) {
            Integer count = wordCount.get(word);
            wordCount.put(word, (count == null) ? 1 : count + 1);
            if(wordCount.get(word) > 1){
                list.add(word);
            }
        }
    }
    return list;
}

private static String viewResult(List<String> list1, List<String> list2, List<String> duplicate){
    String result;
    StringBuilder SB = new StringBuilder("</br>");
    SB.append("Entries only on LEFT: </br>");
    list1.forEach(e -> SB.append(e + "</br>"));
    SB.append("Entries only on RIGHT: </br>");
    list2.forEach(e -> SB.append(e + "</br>"));
    SB.append("Entries full difference : </br>");
    duplicate.forEach(e -> SB.append(e + "</br>"));
    result = SB.toString();
    return result;
}