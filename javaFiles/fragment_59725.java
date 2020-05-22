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
      destinationFile = file( "${rootProject.buildDir}/jacoco/jacocoTest.exec" ) 
    }
  }
}
[...]
sonarqube {
  properties {
    [...]
    property "sonar.jacoco.reportPath", "${buildDir}/jacoco/*.exec"
  }
}