public static void main(String[] args) {
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put("test", "test");
    System.out.println(myHashMap.get("test:lower"));
    System.out.println(myHashMap.get("test:upper"));
}