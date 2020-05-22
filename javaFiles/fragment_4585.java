public class EnvironmentInfo {

     private static final ENVIRONMENT_IDENTIFIER_PARAMETER = "env";
     private static final Set<String> TEST_ENVIRONMENTS = ImmutableSet.of("test"); // this requires Guava

     public static boolean isTestEnvironment() {
         return TEST_ENVIRONMENTS.contains(System.getProperty(ENVIRONMENT_IDENTIFIER_PARAMETER));
     }

}