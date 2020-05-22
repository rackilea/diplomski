@Singleton
public class OnStartupService {

    @Inject
    private OnStartupService(Environment environment, Yaml yaml) {
        if (environment.isDev()) {
            if (Issue.find.findRowCount() == 0) {
                Ebean.saveAll((Collection<?>) yaml.load("test-data.yml"));
            }
        }
    }
}