public static void main(String[] args) throws Exception {
    List<String> someList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");

    //make a copy if you want the initial collection intact
    List<String> random = new ArrayList<> (someList);
    Collections.shuffle(random);

    for (String s : random) {
        System.out.print(s);
    }
}