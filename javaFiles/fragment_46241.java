static List<String> list = Arrays.asList("G1", "G12", "G1-G2", "G23");
public static void main(String[] args) throws Exception {
    new ArrayList<>(Arrays.asList("G1", "G12", "G2", "G23")).forEach(s -> func(s));
}

static void func(String input) {
    String regex = ".*(?=\\b" + input + "\\b).*";
    System.out.println(input + " contained in -> " 
                       + Arrays.toString(IntStream.range(0, list.size())
                                       .filter(i -> list.get(i).matches(regex))
                                       .toArray()));
}