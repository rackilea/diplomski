allprojects {
    apply plugin: 'java'
    repositories {
        mavenCentral()
    }
}

task copyJars(type: Copy, dependsOn: subprojects.jar) {
    from(subprojects.jar) 
    into project.file('dest')
}

task copyDeps(type: Copy) {
    from(subprojects.configurations.runtime) 
    into project.file('dest/lib')
}

task copyFiles(dependsOn: [copyJars, copyDeps])