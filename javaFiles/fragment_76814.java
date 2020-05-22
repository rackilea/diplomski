import java.io.File;

class JavawLocation {

    public static void main(String[] args) {
        String javaHome = System.getProperty("java.home");
        File f = new File(javaHome);
        f = new File(f, "bin");
        f = new File(f, "javaw.exe");
        System.out.println(f + "    exists: " + f.exists());
    }
}