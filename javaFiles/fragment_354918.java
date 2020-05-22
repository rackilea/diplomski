@Test
public void testMutableMap() throws Exception {

    List<String> badGuys = Arrays.asList("Inky", "Blinky", "Pinky",
            "Pinky", "Clyde");
    Function<String, Integer> stringLengthFunction = new Function<String, Integer>() {

        public Integer apply(String input) {
            return input.length();
        }
    };

    Multimap<Integer, String> multipmap = indexMutable(badGuys,
            stringLengthFunction);

    System.out.println(multipmap);
    multipmap.clear();
    System.out.println("It's mutable!");

    for (String guy : badGuys) {
        multipmap.get(stringLengthFunction.apply(guy)).add(guy);
    }

    System.out.println(multipmap);
}