@FXML
public void UseAddLesson() throws IOException{
    String searchText = ID1.getText();
    Path p = Paths.get("src", "inware", "students.txt");
    Path tempFile = Files.createTempFile(p.getParent(), "studentsTemp", ".txt");
    try (BufferedReader reader = Files.newBufferedReader(p);
            BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
        String line;

        // copy everything until the id is found
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            if (line.contains(searchText)) {
                writer.write(","+glossa.getText()+",");
                writer.write(math.getText()+",");
                writer.write(fis.getText()+",");
                writer.write(xim.getText()+",");
                writer.write(prog.getText()+",");
                writer.write(gym.getText());
                break;
            }
            writer.newLine();
        }

        // copy remaining lines
        if (line != null) {
            writer.newLine();
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    // copy new file & delete temporary file
    Files.copy(tempFile, p, StandardCopyOption.REPLACE_EXISTING);
    Files.delete(tempFile);
}