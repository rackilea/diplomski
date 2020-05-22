@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Info {
  private final String activeProfile;
  private final Instant timestamp;

  public Info(@Value("${spring.profiles.active}") String activeProfile) {
    this.activeProfile = activeProfile;
    this.timestamp = Instant.now();
  }
}