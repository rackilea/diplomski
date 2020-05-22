plugins {
    // ...
    id("java")
}

java {
    // Required to make the jar artifact compatible with your backend, which is configured for Java 1.8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.named("jar", Jar::class) {
    dependsOn("assembleFrontend")
    from("$buildDir/dist")
    into("static")
}