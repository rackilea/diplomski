public class DefaultEmailNotificationManager implements IEmailNotificationManager {
  private Collection<IEmailGenerator> generators;
  public void init() {
    for( IEmailGenerator g : generators ) {
      register(g);
    }
  }
  public void setGenerators( Collection<IEmailGenerator> generators ) {
    this.generators = generators;
  }
  public MailResult sendEmail( EmailType type ) { .. }
  private void register( IEmailGenerator generator ) { .. }
}