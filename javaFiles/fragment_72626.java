try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("some file somewhere.txt")))) {
    bw.write(String.format("%-10s%-10s%-10s", "A", "B", "C"));
    bw.newLine();
    for (int index = 0; index < 10; index++) {
        bw.write(String.format("%-10s%-10s%-10s", "a" + index, "b" + index, "c" + index));
        bw.newLine();
    }
} catch (IOException ex) {
    ex.printStackTrace();
}