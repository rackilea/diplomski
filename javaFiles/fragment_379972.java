public Test(){
    array = new ArrayList<ArrayList<String>>();
    array.add(new ArrayList<String>());
    array.add(new ArrayList<String>());
    array.add(new ArrayList<String>());
    array.get(0).add("00");
    array.get(0).add("01");
    array.get(0).add("02");
    array.get(1).add("10");
    array.get(1).add("11");
    array.get(1).add("12");
    array.get(2).add("20");
    array.get(2).add("21");
    array.get(2).add("22");
}