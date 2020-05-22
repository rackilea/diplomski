subprojects {
    apply<JavaLibraryPlugin>()
    apply<MavenPublishPlugin>()

    group = "de.bentolor.sampleproject"
    version = "0.1.0"

    repositories {
        jcenter()
    }

    dependencies {
        val implementation by configurations
        val testImplementation by configurations

        implementation("commons-logging:commons-logging:1.2")
        testImplementation("junit:junit:4.12")
    }

    // This will work, but as long as these tasks are need only for publishing you can declare them inplace later where you need 
    // tasks {
    //     val sourcesJar by creating(Jar::class) {
    //         val sourceSets: SourceSetContainer by project
    //         from(sourceSets["main"].allJava)
    //         classifier = "sources"
    //     }
    //     val javadoc by getting(Javadoc::class)
    //     val javadocJar by creating(Jar::class) {
    //         from(javadoc)
    //         classifier = "javadoc"
    //     }
    // }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    configure<PublishingExtension> {
        publications {
            create<MavenPublication>(project.name) {
                from(components["java"])

                // If you configured them before
                // val sourcesJar by tasks.getting(Jar::class)
                // val javadocJar by tasks.getting(Jar::class)

                val sourcesJar by tasks.creating(Jar::class) {
                    val sourceSets: SourceSetContainer by project

                    from(sourceSets["main"].allJava)
                    classifier = "sources"
                }
                val javadocJar by tasks.creating(Jar::class) {
                    from(tasks.get("javadoc"))
                    classifier = "javadoc"
                }

                artifact(sourcesJar)
                artifact(javadocJar)
            }
        }
    }
}