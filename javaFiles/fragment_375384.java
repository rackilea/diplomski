public class TestPlaceholders {
        @Autowired
        Environment environment;

        public void testPlaceHolders() {
            environment.resolveRequiredPlaceholders("${spring.application.name}"); // your-app-name
            environment.resolveRequiredPlaceholders("${bad.prop:missing}"); // missing
            environment.resolveRequiredPlaceholders("NoPlaceholders"); // NoPlaceholders
        }
    }