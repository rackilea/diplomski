public static void main(String[] args) {

    ArrayList list = new ArrayList(10);
    list.addItem("1", 0);
    list.addItem("3", 1);
    list.addItem("2", 2);
    list.addItem("2", 3);
    list.addItem("4", 4);
    list.addItem("1", 5);
    list.addItem("2", 6);

    System.out.println(list);
    // {1, 3, 2, 2, 4, 1, 2}

    list.removeAll("2");

    System.out.println(list);
    // {1, 3, 4, 1}
}