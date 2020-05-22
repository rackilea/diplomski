import com.google.protobuf.gradle.GenerateProtoTask
plugins {
    java
    id ("com.google.protobuf") version ("0.8.8") apply false
}

allprojects {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

subprojects {
    apply(plugin="java")
    apply(plugin="idea")

    if (name != "proto") {
        tasks.withType<JavaCompile> {
            dependsOn(project(":proto").tasks.withType<GenerateProtoTask>())
        }
    }
}