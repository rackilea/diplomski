public static void main(String[] args) {
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("a");
    stringList.add("b");
    stringList.add("c");

    stringList.stream().forEach(str -> {
        if (str.equals("b")) return; // only skips this iteration.

        System.out.println(str);
    });
}