buildscript {
    repositories {
        jcenter()
        maven {
            url 'https://plugins.gradle.org/m2/'
        }
    }
    dependencies {
        // Add this line
        classpath "org.jfrog.buildinfo:build-info-extractor-gradle:4.0.1"
        classpath 'gradle.plugin.edu.sc.seis.gradle:launch4j:1.6.2'
    }
}


group 'polisotinserter'
version '1.0.0'

// Apply the java plugin to add support for Java
apply plugin: 'java'
apply plugin: 'com.jfrog.artifactory'
apply plugin: 'maven-publish'
apply plugin: 'idea'
apply plugin: 'edu.sc.seis.launch4j'
sourceCompatibility = 1.8

repositories {
    jcenter()
    maven {
        url 'https://artifactory.lyoko.pw:443/libs-release-local'
    }
}

dependencies {
    compile group: 'com.github.axet', name: 'lookup', version: '0.1.30'
    compile group: 'org.seleniumhq.selenium', name: 'selenium-support', version: '3.0.1'
    compile group: 'org.seleniumhq.selenium', name: 'selenium-ie-driver', version: '3.0.1'
    compile "org.jsoup:jsoup:1.8.3"
    compile group: 'javax.mail', name: 'mail', version: '1.4.7'

    compile(group: 'EnglishToHebrewTranslicirator', name: 'EnglishToHebrewTranslicirator', version: 'EnglishToHebrewTranslicirator')
    compile group: 'net.sourceforge.jexcelapi', name: 'jxl', version: '2.6.12'
    compile group: 'org.json', name: 'json', version: '20160810'


    compile(group: 'AbstractConnectionApi', name: 'AbstractConnectionApi', version: '1.0.0')
    compile(group: 'sjxlsx-custom', name: 'sjxlsx-custom', version: '1.0.0')
    compile(group: 'programupdater', name: 'Programs-Updater', version: '1.0.0')
    compile(group: 'com.intellij', name: 'forms_rt', version: '7.0.3+')

}
sourceSets {
    main {
        java {
            srcDir new File(rootProject.projectDir, "src/main/java").getAbsolutePath()
        }
        resources {
            srcDir new File(rootProject.projectDir, "src/main/resources").getAbsolutePath()
        }
    }
}

subprojects {
    apply plugin: 'java'
    repositories {
        jcenter()
        maven {
            url 'https://artifactory.lyoko.pw:443/libs-release-local'
            credentials {
                username = "vasilevich"
                password = "APkgGZjFzEM6Kp1yj1Be3fyrKW"
            }
        }
    }

    sourceSets {
        main {
            java {
                srcDir new File(rootProject.projectDir, "src/main/java").getAbsolutePath()
            }
            resources {
                srcDir new File(rootProject.projectDir, "src/main/resources").getAbsolutePath()
            }
        }
    }
    dependencies {
        compile group: 'com.github.axet', name: 'lookup', version: '0.1.30'

        compile "org.jsoup:jsoup:1.8.3"
        compile group: 'javax.mail', name: 'mail', version: '1.4.7'

        compile(group: 'EnglishToHebrewTranslicirator', name: 'EnglishToHebrewTranslicirator', version: 'EnglishToHebrewTranslicirator')
        compile group: 'net.sourceforge.jexcelapi', name: 'jxl', version: '2.6.12'
        compile group: 'org.json', name: 'json', version: '20160810'


        compile(group: 'AbstractConnectionApi', name: 'AbstractConnectionApi', version: '1.0.0')
        compile(group: 'sjxlsx-custom', name: 'sjxlsx-custom', version: '1.0.0')
        compile(group: 'programupdater', name: 'Programs-Updater', version: '1.0.0')
        compile(group: 'com.intellij', name: 'forms_rt', version: '7.0.3+')


    }
}

project(':CGFetcher') {

    task assembleRelease(type: Jar) {
        classifier = 'release'
        manifest {
            attributes 'Implementation-Title': "CGFetcher",
                    'Implementation-Version': project.version,
                    'Main-Class': 'gui.CGGuiMain'
        }
        baseName = "CGFetcher"
        from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
        with jar
    }
    artifacts {
        archives assembleRelease
    }
}