String[] locations = {"Lisboa", "Porto", "Algarve"};

for (String source : locations) {
    for (String destination : locations) {
        if (!source.equals(destination)) {
            System.out.println(source + " -> " + destination);
        }
    }
}