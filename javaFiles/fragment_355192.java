plugins {
    id 'application'
}

sourceSets {
    main {
        java {
            srcDirs 'appModSrc'
        }
    }
}

application {
    mainClassName 'appPack.Entry'
}

jar {
    doFirst {
        manifest {
            attributes('ModuleMainClass': mainClassName)
        }
    }
}

dependencies {
    implementation project(':src:greetMod')
}