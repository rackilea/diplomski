Map<Integer, List<Object>> map = new TreeMap<Integer, List<Object>>();
while((line=reader.readLine())!=null){
    List<Object> row = new ArrayList<>();
    String[] strArray=line.split(" ");
    row.add(strArray[0]);
    row.add(strArray[1]);
    row.add(strArray[2]);
    row.add(strArray[3]);
    row.add(strArray[4]);
    row.add(strArray[5]);
    map.put(new Integer(row.get(1)), row);
}