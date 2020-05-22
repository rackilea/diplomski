docker {
  dependsOn build
  name "${project.group}/${bootJar.baseName}"
  files bootJar.archivePath, 'application.yml'
  buildArgs(['JAR_FILE': "${bootJar.archiveName}"])
}