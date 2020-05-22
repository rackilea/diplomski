import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@RestController
public class ConfigServer {

  public static void main(String[] args) {
    SpringApplication.run(ConfigServer.class, args);
  }

  @Value("${spring.cloud.config.server.git.uri}")
  private String uri;

  @Autowired private ResourceLoader resourceLoader;

  @GetMapping("/{name}/{profile}/{label}/listFiles")
  public Collection<String> retrieve(
      @PathVariable String name,
      @PathVariable String profile,
      @PathVariable String label,
      HttpServletRequest request)
      throws IOException {
    Resource resource = resourceLoader.getResource(uri);
    String uriPath = resource.getFile().getPath();
    Path namePath = Paths.get(uriPath, name);
    String baseUrl =
        String.format(
            "http://%s:%d/%s/%s/%s",
            request.getServerName(), request.getServerPort(), name, profile, label);
    try (Stream<Path> files = Files.walk(namePath)) {
      return files
          .map(Path::toFile)
          .filter(File::isFile)
          .map(File::getName)
          .map(filename -> baseUrl + "/" + filename)
          .collect(Collectors.toList());
    }
  }
}