/** @param updateLineno counted from 0. */
void updateMaterialsFile(int updatedLineno, String updated) throws IOException {
    Path materialsPath = Paths.get("Materials.txt");
    Path tempPath = materialsPath.resolveSibling("temp.txt");

    try (BufferedReader fr = Files.newBufferedReader(materialsPath);
            BufferedWriter fw = Files.newBufferedWriter(tempPath)) {

        for (int lineno = 0; ; ++lineno) {
            String line = fr.readLine();
            if (line == null) {
                break;
            }
            fw.write(lineno == updatedLineno ? updated : line);
            fw.write("\r\n");
        }
    } // Automatically closes fr and fw
    Files.move(tempPath, materialsPath, StandardCopyOption.REPLACE_EXISTING);
}