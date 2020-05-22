public static void main(String[] args) throws IOException {
    Cosine_Similarity cs = new Cosine_Similarity();

    // read file 1 and convert into a String
    String text1 = Files.readAllLines(Paths.get("path/to/file1")).stream().collect(Collectors.joining(" "));
    // read file 2 and convert into a String
    String text2 = Files.readAllLines(Paths.get("path/to/file2")).stream().collect(Collectors.joining(" "));

    double score = cs.Cosine_Similarity_Score(text1, text2);
    System.out.println("Cosine similarity score = " + score);
}