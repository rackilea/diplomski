allprojects{
    apply plugin:'java'
    apply plugin:'eclipse'

    eclipse.classpath.file {
        beforeMerged { classpath -> classpath.entries.removeAll {it} }
    }
}

project(':A').dependencies {
    compile project(':B'),{ transitive = false }
}

project(':B').dependencies {
    compile project(':C'),{ transitive = false }
}