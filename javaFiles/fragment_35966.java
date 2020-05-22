// inject the project
@Parameter(defaultValue = "${project}")
private org.apache.maven.project.MavenProject project;

// and in execute(), use it:
project.getProperties().setProperty("currentVersion", appCurrentVersion);