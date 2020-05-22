plugins {
  id "com.github.spotbugs" version "1.6.0"
}

apply plugin: 'maven'
apply plugin: 'maven-publish'
apply plugin: 'java-library'
apply plugin: 'com.github.spotbugs'

sourceCompatibility = 8
targetCompatibility = 8

group = 'com.dua3.utility'

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
  compile group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.10.0'
  testRuntime group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.10.0'

  // Use JUnit test framework
  testImplementation 'junit:junit:4.12'
}

ext.moduleName = 'com.dua3.utility' 

sourceSets {
    moduleInfo {
        java {
            srcDir 'src/module-info/java'            
        }
    }
}

compileModuleInfoJava {
    sourceCompatibility = 9
    targetCompatibility = 9

    inputs.property("moduleName", moduleName)

    doFirst {
        classpath += sourceSets.main.compileClasspath

        options.compilerArgs = [
            '--module-path', classpath.asPath,
            '--add-modules', 'ALL-SYSTEM',
            '-d', sourceSets.main.output.classesDirs.asPath
        ]
    }
}

jar 
{
    from sourceSets.main.output
    from sourceSets.moduleInfo.output
}

spotbugs {
    sourceSets = [sourceSets.main]
}

tasks.withType(com.github.spotbugs.SpotBugsTask) {
    reports {
        xml.enabled false
        html.enabled true
    }
}

task sourcesJar(type: Jar, dependsOn: classes) {
    classifier = 'sources'
    from sourceSets.main.allSource
}

task javadocJar(type: Jar, dependsOn: javadoc) {
    classifier = 'javadoc'
    from javadoc.destinationDir
}

artifacts {
    archives sourcesJar
    archives javadocJar
}

defaultTasks 'build', 'publishToMavenLocal', 'install'