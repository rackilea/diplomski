apply plugin: 'java'
apply plugin: 'maven-publish'

group = 'com.stackoverflow.phillip' // change it
version = '1.0' // whatever

dependencies {
    // ...
}

publishing {
    publications {
        maven(MavenPublication) {
            from components.java
            // uncomment if you want to change artifact id (the default equals to project directory name)
            //artifactId 'my-lib'
        }
    }

    repositories {
        maven {
            url 'file:local-repo' // path is relative to project root
        }
    }
}