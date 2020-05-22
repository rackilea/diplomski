@RestController
public class InfoRestController { 
  @Autowire
  private Provider<Info> infoProvider;

  @GetMapping
  public Info getInfo() {
    return infoProvider.get();
  } 
}