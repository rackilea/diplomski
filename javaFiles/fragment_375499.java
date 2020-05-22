import static org.junit.Assert.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CommonMp {

    private final Charset CS = StandardCharsets.UTF_8;

    @Test
    public void testLocalMp() {

        Path testInputFile = null, testOutputFile = null;
        try {
            testInputFile = prepareInputFile();
            LocalFileItem lfi = new LocalFileItem(testInputFile);
            CommonsMultipartFile cmf = new CommonsMultipartFile(lfi);
            System.out.println("Empty: " + cmf.isEmpty());
            testOutputFile = testInputFile.getParent().resolve("testMpOutput.txt");
            cmf.transferTo(testOutputFile.toFile());
            System.out.println("Size: " + cmf.getSize());
            printOutput(testOutputFile);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        } finally {
            deleteSilent(testInputFile, testOutputFile);
        }
    }

    @Test
    public void testMp() {

        Path testInputFile = null, testOutputFile = null;
        try {
            testInputFile = prepareInputFile();
            DiskFileItem di = new DiskFileItem("file", "text/plain", false, testInputFile.getFileName().toString(), 
                    (int) Files.size(testInputFile), testInputFile.getParent().toFile());
            try (OutputStream out = di.getOutputStream();
                    InputStream in = Files.newInputStream(testInputFile)) {
                IOUtils.copy(in, out);
            }
            CommonsMultipartFile cmf = new CommonsMultipartFile(di);
            System.out.println("Size: " + cmf.getSize());
            testOutputFile = testInputFile.getParent().resolve("testMpOutput.txt");
            cmf.transferTo(testOutputFile.toFile());
            printOutput(testOutputFile);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        } finally {
            deleteSilent(testInputFile, testOutputFile);
        }
    }

    private Path prepareInputFile() throws IOException {

        Path tmpDir = Paths.get(System.getProperty("java.io.tmpdir"));
        Path testInputFile = tmpDir.resolve("testMpinput.txt");
        try (OutputStream out = Files.newOutputStream(testInputFile)){
            out.write("Just a test.".getBytes(CS));
        }
        return testInputFile;
    }

    private void printOutput(Path p) throws IOException {

        byte[] outBytes = Files.readAllBytes(p);
        System.out.println("Output: " + new String(outBytes, CS));
    }

    private void deleteSilent(Path... paths) {

        for (Path p : paths) {
            try { if (p != null) p.toFile().delete(); } catch (Exception ignored) {}
        }
    }

}