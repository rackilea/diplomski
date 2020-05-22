plugins {
    // Plugin to build .exe files.
    id("edu.sc.seis.launch4j") version "2.4.4"
}

dependencies {
    // JNA, used to e.g. make a program pinnable to taskbar.
    compile("net.java.dev.jna:jna:4.5.1")
    compile("net.java.dev.jna:jna-platform:4.5.1")
}

launch4j {
    mainClassName = "nl.mynamespace.myapp.MainKt"
    icon = "$projectDir/src/main/resources/myapp32.ico"
    manifest = "$projectDir/releasing/launch4j/myapp.manifest"
}