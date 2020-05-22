if (project.hasProperty('jenkins')) {
    repositories {
        maven {
            url "${jenkinsRepoUrl}"
        }
    }
} else {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

dependencies {
    compile (
        ['commons-lang:commons-lang:2.4'],
        ["Lib_ProjectB:ProjectB:${ProjectB_Version}"],
    }
}