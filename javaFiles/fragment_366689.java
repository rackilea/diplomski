public static void main(String[] args) {
    String placeStr = "***place1*place2**place3*";
    placeStr = placeStr.replaceAll("^[*]+", "");
    String[] places = placeStr.split("[*]+");
    System.out.println("places.length: " + places.length);
    Arrays.asList(places).forEach(System.out::println);
}