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
        compileOnly group: 'com.github.axet', name: 'lookup', version: '0.1.30'
        compileOnly group: 'org.seleniumhq.selenium', name: 'selenium-support', version: '3.0.1'
        compileOnly group: 'org.seleniumhq.selenium', name: 'selenium-ie-driver', version: '3.0.1'
        compileOnly group: 'javax.mail', name: 'mail', version: '1.4.7'
        compileOnly(group: 'EnglishToHebrewTranslicirator', name: 'EnglishToHebrewTranslicirator', version: 'EnglishToHebrewTranslicirator')
        compileOnly group: 'org.json', name: 'json', version: '20160810'
        compileOnly(group: 'AbstractConnectionApi', name: 'AbstractConnectionApi', version: '1.0.0')
        compileOnly(group: 'sjxlsx-custom', name: 'sjxlsx-custom', version: '1.0.0')
        compileOnly "org.jsoup:jsoup:1.8.3"
        compileOnly(group: 'programupdater', name: 'Programs-Updater', version: '1.0.0')
        compileOnly(group: 'com.intellij', name: 'forms_rt', version: '7.0.3+')
        compileOnly group: 'net.sourceforge.jexcelapi', name: 'jxl', version: '2.6.12'

    }
}

project(':CGFetcher') {
    dependencies {
        compile "org.jsoup:jsoup:1.8.3"
        compile(group: 'programupdater', name: 'Programs-Updater', version: '1.0.0')
        compile(group: 'com.intellij', name: 'forms_rt', version: '7.0.3+')
        compile group: 'net.sourceforge.jexcelapi', name: 'jxl', version: '2.6.12'

    }
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