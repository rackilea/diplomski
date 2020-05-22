import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class TestYml {
  public static void main(String[] args) throws Exception {
    Yaml yaml = new Yaml();
    InputStream inputStream =
        new FileInputStream("your location\\yml-file-name.yml");

    Recipe recipe = yaml.loadAs(inputStream,Recipe.class);
    System.out.println("recipe = " + recipe);
  }
}