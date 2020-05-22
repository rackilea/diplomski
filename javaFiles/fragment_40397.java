Random rand = new Random();

    Map<Integer, String> colours = new HashMap<>();
    colours.put(1, "red");
    colours.put(2, "white");
    colours.put(3, "purple");
    colours.put(4, "orange");
    colours.put(5, "pink");
    colours.put(6, "yellow");
    colours.put(7, "green");
    colours.put(8, "blue");

    List<String> answer = new ArrayList<String>();
    answer.add(colours.get(rand.nextInt(7) + 1));
    answer.add(colours.get(rand.nextInt(7) + 1));
    answer.add(colours.get(rand.nextInt(7) + 1));
    answer.add(colours.get(rand.nextInt(7) + 1));