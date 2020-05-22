public class Test2 {

    public static void main(String[] args) {
        String fileName = "c://lines.txt";
        String name = "nametosearch";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.filter(line -> line.contains(" " + name + " ")).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}