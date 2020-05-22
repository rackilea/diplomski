public class SymLink {

    public static void main(String... args) throws IOException {
        String originName = "c:\\ThisIsJunk";
        String targetName = originName + "SymLnk";
        Path origin = Files.createDirectories(Paths.get(originName));
        Path target = Paths.get(targetName);
        try {
            Files.delete(target);
        } catch (NoSuchFileException e) {
        }
        try {
            Path symLink = Files.createSymbolicLink(target, origin);
            System.out.println("Symbolic link created: " + symLink.toString());
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }
}