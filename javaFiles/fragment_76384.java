package sub.optimal;

import java.io.InputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.Desktop;

public class REPL {

    public static void main(String[] args) throws Exception {
        String inputPdf = "doc/manual.pdf";
        Path tempOutput = Files.createTempFile("TempManual", ".pdf");
        tempOutput.toFile().deleteOnExit();
        System.out.println("tempOutput: " + tempOutput);
        try (InputStream is = REPL.class.getClassLoader().getResourceAsStream(inputPdf)) {
            Files.copy(is, tempOutput, StandardCopyOption.REPLACE_EXISTING);
        }
        Desktop.getDesktop().open(tempOutput.toFile());
    }
}