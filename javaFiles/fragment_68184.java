import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class UacTest {

    public static String jarName = "UacTest.jar", batName = "elevate.bat";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (checkForUac()) {//uac is on
            JOptionPane.showMessageDialog(null, "I am not elevated");
            //attempt elevation
            new UacTest().elevate();
            System.exit(0);
        } else {//uac is not on
            //if we get here we are elevated
            JOptionPane.showMessageDialog(null, "I am elevated");
        }

    }

    private static boolean checkForUac() {
        File dummyFile = new File("c:/aaa.txt");
        dummyFile.deleteOnExit();

        try {
            //attempt to craete file in c:/
            try (FileWriter fw = new FileWriter(dummyFile, true)) {
            }
        } catch (IOException ex) {//we cannot UAC muts be on
            //ex.printStackTrace();
            return true;
        }
        return false;
    }

    private void elevate() {
        //create batch file in temporary directory as we have access to it regardless of UAC on or off
        File file = new File(System.getProperty("java.io.tmpdir") + "/" + batName);
        file.deleteOnExit();

        createBatchFile(file);

        runBatchFile();

    }

    private String getJarLocation() {
        return getClass().getProtectionDomain().getCodeSource().getLocation().getPath().substring(1);
    }

    private void runBatchFile() {
        //JOptionPane.showMessageDialog(null, getJarLocation());

        Runtime runtime = Runtime.getRuntime();
        String[] cmd = new String[]{"cmd.exe", "/C",
            System.getProperty("java.io.tmpdir") + "/" + batName + " java -jar " + getJarLocation()};
        try {
            Process proc = runtime.exec(cmd);
            //proc.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createBatchFile(File file) {
        try {
            try (FileWriter fw = new FileWriter(file, true)) {
                fw.write(
                        "@echo Set objShell = CreateObject(\"Shell.Application\") > %temp%\\sudo.tmp.vbs\r\n"
                        + "@echo args = Right(\"%*\", (Len(\"%*\") - Len(\"%1\"))) >> %temp%\\sudo.tmp.vbs\r\n"
                        + "@echo objShell.ShellExecute \"%1\", args, \"\", \"runas\" >> %temp%\\sudo.tmp.vbs\r\n"
                        + "@cscript %temp%\\sudo.tmp.vbs\r\n"
                        + "del /f %temp%\\sudo.tmp.vbs\r\n");
            }
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }
}