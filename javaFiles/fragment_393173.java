String abc = "123XXXXX0";
List<String> lstValues = new ArrayList<>(List.of("111XXXX1", "122XXX1", "123XXXX1"));
if (lstValues.stream().map(x -> x.substring(0, 3)).anyMatch(abc.substring(0, 3)::equals)) {
    System.out.println("**** Match Found ***");
} else {
    System.out.println("**** No Match Found ****");
}