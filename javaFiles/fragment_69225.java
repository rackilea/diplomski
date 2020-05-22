import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

Path p = Paths.get("/tmp/.minecraft");

if(!Files.exists(p)){
    Files.createFile(p);
}
if(Files.exists(p)){
    Files.delete(p);
}