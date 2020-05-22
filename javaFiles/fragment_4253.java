plugins {
    id 'java'
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.8'
    id 'org.beryx.runtime' version '1.7.0'
    id "com.github.johnrengelman.shadow" version "5.1.0"
}

repositories {
    mavenCentral()
}

ext {
    openJfxVersion = '13'
}

dependencies {
    compile 'org.openjfx:javafx-base:${openJfxVersion}:win'
    compile 'org.openjfx:javafx-controls:${openJfxVersion}:win'
    compile 'org.openjfx:javafx-graphics:${openJfxVersion}:win'
    compile 'org.openjfx:javafx-fxml:13'
}


javafx {
    version = "13"
    modules = [ 'javafx.controls','javafx.graphics', 'javafx.fxml'  ]
}

mainClassName = 'Main'

runtime {
    options = ['--strip-debug', '--compress', '2', '--no-header-files', '--no-man-pages']

    jpackage {
        jpackageHome = 'C:/Program Files/Java/openjdk-14-jpackage+1-49_windows-x64_bin/'


        if(org.gradle.internal.os.OperatingSystem.current().windows) {
            installerType = 'msi'
            imageOptions = ['--icon', 'src/main/resources/images/logo.ico']
            installerOptions = ['--win-per-user-install',
                '--win-dir-chooser',
                '--win-menu',
                '--win-shortcut',
                '--verbose',
                '--description','x ',
                '--name', 'x',
                '--vendor','x',
                '--win-upgrade-uuid','x']
        }
    }

}

compileJava {
    compileJava.options.encoding = 'ISO-8859-1'
    doFirst {
        options.compilerArgs = [
                '--module-path', classpath.asPath,
                '--add-modules', 'javafx.controls,javafx.fxml'
        ]
    }
}

run {
    doFirst {
        jvmArgs = [
                '--module-path', classpath.asPath,
                '--add-modules', 'javafx.controls,javafx.fxml'
        ]
    }
}



group = 'br.x'
version = '0.1'

tasks.withType(JavaCompile) {
    options.encoding = 'ISO-8859-1'
}