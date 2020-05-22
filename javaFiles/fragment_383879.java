public static void lotoGame() {
    Random rand = new Random();
    Map<Integer, Integer> loto = new HashMap<>();
    while (loto.keySet().size() < 6) {
        int lottoNumber = rand.nextInt(49) + 1;
        loto.compute(lottoNumber, (key, value) -> value == null ? 1 : ++value);
    }

    loto.forEach((key,value)->{
        System.out.println(key + " occurs " + value + " times");
    });
}