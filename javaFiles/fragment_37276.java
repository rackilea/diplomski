@Override
public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
    if (attr.isRegularFile() && file.getFileName().toString().endsWith(".html")) {
        Charset charset = Charset.forName("UTF-16");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
           String line;
           while ((line = reader.readLine()) != null) {
               System.out.println(line); //do what you need to do here
            }
         } catch (IOException x) {
             //Print / log the errror
         }
    }
    return CONTINUE;
}