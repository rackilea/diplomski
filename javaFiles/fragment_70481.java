import java.io.File;

class FindDesktopOnWindows {

    public static void main(String[] args) throws Exception {
        if (System.getProperty("os.name").toLowerCase().indexOf("win")<0) {
            System.err.println("Sorry, Windows only!");
            System.exit(1);
        }
        File desktopDir = new File(System.getProperty("user.home"), "Desktop");
        System.out.println(desktopDir.getPath() + " " + desktopDir.exists());

        java.awt.Desktop.getDesktop().open(desktopDir);
    }
}