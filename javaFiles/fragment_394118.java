public static void condense2(List<String> list){
    int groupSize = 2;
    List<String> result = new ArrayList<>();        
    for (int i = 0; i < list.size(); i += groupSize) {
        result.add(String.join("", list.subList(i,Math.min(i + groupSize, list.size()))));            
    }
    System.out.println(result);
}