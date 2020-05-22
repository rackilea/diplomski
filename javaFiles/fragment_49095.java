public static void main(String[] args) throws Exception {

    Node top = new Node(5);
    top.setLeft(new Node(3));
    top.setRight(new Node(7));
    top.getLeft().setLeft(new Node(1));
    System.out.println("Contains 5? " + contains(top, 5));
    System.out.println("Contains 3? " + contains(top, 3));
    System.out.println("Contains 7? " + contains(top, 7));
    System.out.println("Contains 9? " + contains(top, 9));

}