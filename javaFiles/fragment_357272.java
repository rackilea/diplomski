task compile << { 
    println "compiling..." 
}

task build() << {
}

build.dependsOn { 
    compile
}

build.dependsOn { 

    if (pkgTarget == "Amazon") {
        task doPack(type: AmazonPackageTask)
    } else if (pkgTarget == "Google") {
        task doPack(type: GooglePackageTask)
    } else {
        task doPack(type: MyPackageTask) 
    }
}