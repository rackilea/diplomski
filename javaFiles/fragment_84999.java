public static void main(String[] args) {
    BinarySearchTree<Golfer> bst = new BinarySearchTree<Golfer>();
    bst.add(new Golfer("A", 10));
    bst.add(new Golfer("B", 12));
    bst.add(new Golfer("C", 8));
    bst.add(new Golfer("D", 9));
    bst.add(new Golfer("E", 3));

    Golfer min = new Test().min(bst);
    //Golfer min = new Test().min2(bst);
    if (min != null) {
        System.out.println("min name: " + min.name + ", min score: " + min.score);
    } else {
        System.out.println("Empty tree");
    }
}