/**
 * 
 * @plexus.component 
 *                   role="org.codehaus.plexus.component.configurator.ComponentConfigurator"
 *                   role-hint="include-project-dependencies"
 * @plexus.requirement role=
 *                     "org.codehaus.plexus.component.configurator.converters.lookup.ConverterLookup"
 *                     role-hint="default"
 * 
 */
public class ClassRealmConfigurator extends AbstractComponentConfigurator {

    private final static Logger logger = Logger.getLogger(ClassRealmConfigurator.class.getName());

    public void configureComponent(Object component, PlexusConfiguration configuration, ExpressionEvaluator expressionEvaluator, ClassRealm containerRealm, ConfigurationListener listener) throws ComponentConfigurationException {

        addProjectDependenciesToClassRealm(expressionEvaluator, containerRealm);

        converterLookup.registerConverter(new ClassRealmConverter(containerRealm));

        ObjectWithFieldsConverter converter = new ObjectWithFieldsConverter();

        converter.processConfiguration(converterLookup, component, containerRealm.getClassLoader(), configuration, expressionEvaluator, listener);
    }

    private void addProjectDependenciesToClassRealm(ExpressionEvaluator expressionEvaluator, ClassRealm containerRealm) throws ComponentConfigurationException {
        Set<String> runtimeClasspathElements = new HashSet<String>();
        try {
            runtimeClasspathElements.addAll((List<String>) expressionEvaluator.evaluate("${project.runtimeClasspathElements}"));

        } catch (ExpressionEvaluationException e) {
            throw new ComponentConfigurationException("There was a problem evaluating: ${project.runtimeClasspathElements}", e);
        }

        Collection<URL> urls = buildURLs(runtimeClasspathElements);
        urls.addAll(buildAritfactDependencies(expressionEvaluator));
        for (URL url : urls) {
            containerRealm.addConstituent(url);
        }
    }

    private Collection<URL> buildAritfactDependencies(ExpressionEvaluator expressionEvaluator) throws ComponentConfigurationException {
        MavenProject project;
        try {
            project = (MavenProject) expressionEvaluator.evaluate("${project}");
        } catch (ExpressionEvaluationException e1) {
            throw new ComponentConfigurationException("There was a problem evaluating: ${project}", e1);
        }
        Collection<URL> urls = new ArrayList<URL>();
        for (Object a : project.getArtifacts()) {
            try {
                urls.add(((Artifact) a).getFile().toURI().toURL());
            } catch (MalformedURLException e) {
                throw new ComponentConfigurationException("Unable to resolve artifact dependency: " + a, e);
            }
        }
        return urls;
    }

    private Collection<URL> buildURLs(Set<String> runtimeClasspathElements) throws ComponentConfigurationException {

        List<URL> urls = new ArrayList<URL>(runtimeClasspathElements.size());
        for (String element : runtimeClasspathElements) {
            try {
                final URL url = new File(element).toURI().toURL();
                urls.add(url);
            } catch (MalformedURLException e) {
                throw new ComponentConfigurationException("Unable to access project dependency: " + element, e);
            }
        }

        return urls;
    }

}