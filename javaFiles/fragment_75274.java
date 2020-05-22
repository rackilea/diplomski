publications {
        mavenJava(MavenPublication) {
            groupId libraryGroupId
            version libraryVersion
            artifactId libraryArtifactId
            from components.java
        }
    }