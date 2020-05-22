public static void main(String[] args) {
    List<String> input = new ArrayList<String>();
    input.add("a");
    input.add("b");
    input.add("c");
    input.add("d");

    List<String> existing = new ArrayList<String>();
    existing .add("d");
    existing .add("b");
    existing .add("z"); 

    Collection<String> newStuff = CollectionUtils.subtract(input, existing);
    Collection<String> updateStuff = CollectionUtils.subtract(input,newStuff);

    System.out.println(newStuff);
    System.out.println(updateStuff);
}