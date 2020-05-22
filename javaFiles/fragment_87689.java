private void mapLoader(String path) {
    try (Scanner s = new Scanner(getClass().getResourceAsStream(path)) {
        while (s.hasNext()) {
            int character = Integer.parseInt(s.next());
            this.getMap().add(character);
        }
    } catch (IOException e) {
        System.err.println("The map could not be loaded.");
        e.printStackTrace();
    }
}