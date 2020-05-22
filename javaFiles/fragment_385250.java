apply plugin: 'war'

apply plugin: 'eclipse-wtp'

configurations {
    shareable
    publishedWar // need this so war gets placed in ear instead of jar, 
                 // using archives puts both wars in ear
}

dependencies {
    providedCompile project(':Common');
    shareable project(':Common');
}

war {
    baseName = war.baseName + '-thin'
    classpath = war.classpath
}

task standaloneWar(type: War, dependsOn: war) {
    baseName = project.name  // sharable war's name without modifications
    classpath = war.classpath + configurations.shareable
}

artifacts {
    archives standaloneWar
    publishedWar war // to be included in ear
}