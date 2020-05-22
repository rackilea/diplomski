plugins {
  id "io.swagger.core.v3.swagger-gradle-plugin" version "2.0.10"
}

configurations {
    swagger {
        extendsFrom runtimeClasspath
        resolutionStrategy {
            force 'com.fasterxml.jackson.core:jackson-databind:2.9.10'
            force 'com.fasterxml.jackson.core:jackson-annotations:2.9.10'
        }
    }
}

dependencies {
    implementation 'io.swagger.core.v3:swagger-annotations:2.0.10'
    implementation "com.fasterxml.jackson.core:jackson-databind:2.10.0"
    implementation "com.fasterxml.jackson.core:jackson-annotations:2.10.0"
    // ...
}

resolve {
    classpath = sourceSets.main.output + configurations.swagger
    // ...
}