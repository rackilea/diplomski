public static void main(String[] args) throws IOException {

    Scanner in = new Scanner(System.in);
    System.out.println("Enter a filename to read from.");
    String filename = in.nextLine();

    Map<Character, Long> freq = Files.lines(Paths.get(filename))
            .flatMap(line -> line.chars().mapToObj(i -> (char) i))
            .collect(groupingBy(x -> x, counting()));

    long total = freq.values().stream().mapToLong(x->x).sum();

    freq.forEach((chr, count) ->
            System.out.format("Frequency of %s: %s%n", chr, ((double) count) / total)
    );

}