sourceSets {  
    main {  
        java {  
            srcDir 'src'  
        }  
    }  
} 

// holds classes included into client.jar and util.jar, so they are to be excluded from server.jar
ext.serverExcludes = []

// util.jar
task utilJar(type: Jar) {  
    from(sourceSets.main.output) {  
        include "my/util/package/**" 
        project.ext.serverExcludes.addAll(includes)
    }  
}

// client.jar
task clientJar(type: Jar) {  
    from(sourceSets.main.output) {  
        include "my/client/package/**"
        project.ext.serverExcludes.addAll(includes)
    }  
}

// server.jar
task serverJar(type: Jar) {  
    from(sourceSets.main.output) {  
        exclude project.ext.serverExcludes
    }  
}