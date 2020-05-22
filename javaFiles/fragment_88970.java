import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

Path pdfPath = Paths.get("/path/to/file.pdf");
byte[] pdf = Files.readAllBytes(pdfPath);