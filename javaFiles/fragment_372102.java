public static void main(String[] args) throws IOException {
    final String input = "Marc Louie, Garduque Bautista";
    final Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
    if (!pattern.matcher(input).matches()) {
        throw new IllegalArgumentException("Invalid String");
    }
}