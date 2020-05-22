private static Vertx vertx = Vertx.vertx();

    public static void main(String[] args) {

        String alphabet = "AB";
        String[] splittedAlphabet = alphabet.split("");
        List<String> list = Arrays.asList(splittedAlphabet);
        iterate(list.iterator());
    }

    public static void iterate(Iterator<String> characters) {
        if (characters.hasNext()) {
            asyncCall(characters);
        } else {
            vertx.close();
        }
    }

    private static void asyncCall(Iterator<String> characters) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Iterator<Integer> numberIterator = numbers.iterator();
        final String character = characters.next();

        vertx.setPeriodic(1000, id -> {
            if (numberIterator.hasNext()) {
                System.out.println(character + " i: " + numberIterator.next());
            } else {
                vertx.cancelTimer(id);
                iterate(characters);
            }
        });

    }