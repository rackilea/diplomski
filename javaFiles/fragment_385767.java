private static FileWriter fileMaker(String fileName) throws IOException {
    return new FileWriter("./artifact/" + fileName + ".txt");
}

private void a() {
    try (FileWriter bufferedWriter = fileMaker("A")) {
        bufferedWriter.write("x");
        b();
        bufferedWriter.write("z");
    } catch (IOException e) {
    }
}

private void b() {
    try (FileWriter bufferedWriter = fileMaker("B")) {
        bufferedWriter.write("b");
    } catch (IOException e) {
    }
}