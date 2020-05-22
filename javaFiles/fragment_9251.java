public class Test {
    public static void main(String[] args) {
        Set<PosixFilePermission> fullPermission = new HashSet<PosixFilePermission>();
        fullPermission.add(PosixFilePermission.OWNER_EXECUTE);
        fullPermission.add(PosixFilePermission.OWNER_READ);
        fullPermission.add(PosixFilePermission.OWNER_WRITE);

        fullPermission.add(PosixFilePermission.GROUP_EXECUTE);
        fullPermission.add(PosixFilePermission.GROUP_READ);
        fullPermission.add(PosixFilePermission.GROUP_WRITE);

        fullPermission.add(PosixFilePermission.OTHERS_EXECUTE);
        fullPermission.add(PosixFilePermission.OTHERS_READ);
        fullPermission.add(PosixFilePermission.OTHERS_WRITE);

        Path path = Paths.get("/tmp/data/", "01/26");
        try {
            Files.createDirectories(path, PosixFilePermissions.asFileAttribute(fullPermission));            
            outputLS(path);         
            Files.setPosixFilePermissions(path, fullPermission);            
            outputLS(path);         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void outputLS(Path path) throws IOException {
        System.out.println(new java.util.Scanner(Runtime.getRuntime().exec("ls -alt " + path.toAbsolutePath() + "/..").getInputStream()).useDelimiter("\\A").next());
    }
}