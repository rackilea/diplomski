public class Hibernate {
    public static void main(String[] args) throws Exception {
        String directory = "c:\\";

        Path start = FileSystems.getDefault().getPath(directory);
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                    BasicFileAttributes attrs) throws IOException {

                if (file.toString().contains("hiberfil.sys")) 
                    System.out.println(file);

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exp) {
                // System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}