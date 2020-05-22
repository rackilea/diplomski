List<String> strings = Files.readAllLines(Paths.get("test.txt"));
List<Konto> kontos = new ArrayList<>();
for (String string : strings) {
    String[] data = string.split(" ");
    kontos.add(new Konto(data[1], new Date(data[2])));
}