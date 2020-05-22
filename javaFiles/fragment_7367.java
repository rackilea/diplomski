plugins {
    // Apply the application plugin to add support for building a CLI application.
    // The application plugin implicitly applies the Java plugin
    id("application")
}

repositories {
    // Use central for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.pi4j:pi4j-parent:1.2")
}

application {
    // Define the main class for the application.
    mainClassName = "io.mateo.MyApplication"
}