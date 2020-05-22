public static void main(String[] args) {
    Linked linked = new Linked();
    linked.add("data3");
    linked.add("data2");
    linked.add("data1");
    System.out.println( linked );

    System.out.println( linked.get(1) );
    System.out.println( linked.get(2) );
    System.out.println( linked.get(3) );
    System.out.println( linked.get(4) );
}