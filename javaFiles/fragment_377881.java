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