try (FileReader fr = new FileReader(file); FileWriter fw = new FileWriter(file2)) {
    while ((c = fr.read()) != -1) {
        fw.write((char) c);
        if (c == 59) {
            fw.write("\n");
        }
    }
}