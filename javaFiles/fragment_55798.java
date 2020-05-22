allprojects{
    apply plugin:'eclipse'

    eclipse.classpath.file {
        beforeMerged { classpath -> classpath.entries.removeAll{it} }
    }
}