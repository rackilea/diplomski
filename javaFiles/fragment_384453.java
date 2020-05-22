// get the default custom classpath from the preferences
AntCorePreferences corePreferences = AntCorePlugin.getPlugin().getPreferences();
URL[] urls = corePreferences.getURLs();

// get the location of the plugin jar
File bundleFile = FileLocator.getBundleFile(myPlugin.getBundle());
URL url = bundleFile.toURI().toURL();

// bond urls to complete classpath
List<URL> classpath = new ArrayList<URL>();
classpath.addAll(Arrays.asList(urls));
classpath.add(url);

AntRunner runner = new AntRunner();
// set custom classpath
runner.setCustomClasspath(classpath.toArray(new URL[classpath.size()]));
// set build file location
runner.setBuildFileLocation(xmlFile.getAbsolutePath());
// set build logger
runner.addBuildLogger(MyDefaultLogger.class.getName());
// set the specific target to be executed
runner.setExecutionTargets(new String[] { "test" });
// run
runner.run();