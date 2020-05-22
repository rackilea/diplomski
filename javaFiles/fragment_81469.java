/**
  * The current project representation.
  * @parameter expression="${project}"
  * @required
  * @readonly
  */
 private MavenProject project;

/**
 * Directory wherein generated source will be put; main, test, site, ... will be added implictly.
 * @parameter expression="${outputDir}" default-value="${project.build.directory}/src-generated"
 * @required
 */
private File outputDir;