apply plugin: 'war'

buildDir = "${rootProject.ext.buildGradle}/${project.name}"
def buildClassesDir = buildDir.getAbsolutePath() + '/classes/main'

configurations {
    localLibraries
}

task bundleJar (type: Jar, dependsOn: ['compileJava']) {
    baseName archivesBaseName
    from buildClassesDir
}

task bundleWar (type: War, dependsOn: ['bundleJar']) {
    dependsOn = [ 'bundleJar' ]
    baseName = project.name
    from 'web'
    webXml = file( 'resources/WEB-INF/web.xml' )
}

dependencies {
    compile group: 'com.system', name: 'core', version: rootProject.version, changing: true
    compile group: 'com.system', name: 'core-ui', version: rootProject.version, changing: true
    compile group: 'com.persistence', name: 'persistence', version: '1.0'
    compile group: 'com.surveys', name: 'survey', version: '1.0'

    // Replace this and make sure all necessary jar dependencies are been fetched from repository instead from file system
    /*localLibraries fileTree("lib") {
        exclude 'spring*'
    }*/
}