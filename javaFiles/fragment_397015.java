import com.google.protobuf.gradle.*

plugins {
    id ("com.google.protobuf")
}

tasks.check { dependsOn("generateProto") }

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.6.1"
    }

    generatedFilesBaseDir = File(project(":java-project").projectDir.toString(), "src").toString()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:3.6.1")
}