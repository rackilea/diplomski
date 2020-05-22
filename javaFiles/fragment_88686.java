import java.io.File;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

// more code

Path filePath = new File("fileName").toPath();
Charset charset = Charset.defaultCharset();        
List<String> stringList = Files.readAllLines(filePath, charset);
String[] stringArray = stringList.toArray(new String[]{});