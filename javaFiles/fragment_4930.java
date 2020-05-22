public static void main(String[] args) {
    Map<Integer[], String> mapka = new HashMap<>();
    Integer[] key = new Integer[]{10, 23};
    mapka.put(key, "Hello");
    System.out.println(mapka.get(key));
}