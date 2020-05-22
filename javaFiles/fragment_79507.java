public static void main(String[] args) {
    Map<Integer, String[]> myTasks = new HashMap<Integer, String[]>();

    myTasks.put(1, new String[] {"cake"});
    myTasks.put(15, new String[] {"bake"});

    String myString = myTasks.get(1)[0];
    System.out.println(myString);
}