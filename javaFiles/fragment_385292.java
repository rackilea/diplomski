$ mvn -Dwtpversion=R7 eclipse:eclipse
[INFO] Scanning for projects...
[INFO] Searching repository for plugin with prefix: 'eclipse'.
[INFO] ------------------------------------------------------------------------
[INFO] Building maven-eclipse-plugin-wtp-testcase
[INFO]    task-segment: [eclipse:eclipse]
[INFO] ------------------------------------------------------------------------
[INFO] Preparing eclipse:eclipse
[INFO] No goals needed for project - skipping
[INFO] [eclipse:eclipse {execution: default-cli}]
[INFO] Adding support for WTP version R7.
[INFO] Using Eclipse Workspace: null
[INFO] Adding default classpath container: org.eclipse.jdt.launching.JRE_CONTAINER
[INFO] Not writing settings - defaults suffice
[INFO] Wrote Eclipse project for "maven-eclipse-plugin-wtp-testcase" to /home/pascal/Projects/maven-eclipse-plugin-wtp-testcase.
[INFO] 
       Javadoc for some artifacts is not available.
       Please run the same goal with the -DdownloadJavadocs=true parameter in order to check remote repositories for javadoc.
       List of artifacts without a javadoc archive:
         o junit:junit:3.8.1

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESSFUL
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3 seconds
[INFO] Finished at: Tue Oct 27 22:49:17 CET 2009
[INFO] Final Memory: 9M/79M
[INFO] ------------------------------------------------------------------------
$ ls -a
.  ..  .classpath  pom.xml  .project  src  .wtpmodules
$ cat .wtpmodules 
<project-modules id="moduleCoreId">
  <wb-module deploy-name="maven-eclipse-plugin-wtp-testcase">
    <module-type module-type-id="jst.web">
      <version>2.4</version>
      <property name="context-root" value="maven-eclipse-plugin-wtp-testcase"/>
    </module-type>
    <wb-resource deploy-path="/" source-path="/src/main/webapp"/>
    <wb-resource deploy-path="/WEB-INF/classes" source-path="src/main/java"/>
  </wb-module>
$