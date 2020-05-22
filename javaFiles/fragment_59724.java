apply plugin: 'base'
apply plugin: 'org.sonarqube'
[...]
allprojects {
  apply plugin: 'java'
  apply plugin: "jacoco"
  [...]
  test {
    [...]
    jacoco {
      append=true
    }
  }
}
[...]
task jacocoMerge( type: JacocoMerge ) {
  dependsOn( subprojects.jacocoTestReport.dependsOn )
  mustRunAfter( subprojects.jacocoTestReport.mustRunAfter )
  destinationFile = file( "${buildDir}/jacoco/mergedTests.exec" )
  executionData = files( subprojects.jacocoTestReport.executionData )
                       .filter { jacocoReportFile -> jacocoReportFile.exists() }
}
tasks.sonarqube.dependsOn jacocoMerge
[...]
sonarqube {
  properties {
    [...]
    property "sonar.jacoco.reportPath", "${buildDir}/jacoco/*.exec"
  }
}