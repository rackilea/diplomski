public static void main(String []args) {
    String EnteredString = "aa  hjkyu  batesh  a";
    List<String> from = new ArrayList<>(Arrays.asList("a", "b", "tes"));
    List<String> to = new ArrayList<>(Arrays.asList("bhduh", "eieja", "neesj"));

    System.out.println(translate(EnteredString, from, to));
}