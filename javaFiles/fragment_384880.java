public abstract class ResourceLoadingTest {

        @Rule public TestName testName = new TestName();

        protected String loadResource(String fileName) throws IOException {
            final URL resource = getClass().getResource(fileName);
            if (resource == null) {
                throw new IllegalArgumentException("No resource file named <" + fileName + "> could be loaded from the classpath.");
            }

            return Resources.toString(resource, Charsets.UTF_8);
        }

        /**
         * Loads a JSON resource whose name is derived from the currently running
         * test. The derived reosurce name is "[test-method-name].json".
         * For example, if this method is called from a test method named
         * <code>testSomeBehavior</code>, then the resource name to be loaded will
         * be <code>testSomeBehavior.json</code>
         */
        protected String loadCurrentTestJSON() throws IOException {
            return loadResource(testName.getMethodName() + ".json");
        }

        /**
         * Loads a XML resource whose name is derived from the currently running
         * test. The derived reosurce name is "[test-method-name].xml".
         * For example, if this method is called from a test method named
         * <code>testSomeBehavior</code>, then the resource name to be loaded will
         * be <code>testSomeBehavior.xml</code>
         */
        protected String loadCurrentTestXML() throws IOException {
            return loadResource(testName.getMethodName() + ".xml");
        }
    }