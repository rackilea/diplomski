task pack(type: JavaExec) {
    classpath = configurations.pack
    workingDir = '~/Dropbox/git/BuildGraph/dist'

    main = 'pack.Main'
    args '-mainjar', 'dist/buildGraph.jar', '-directory', '../lib', '-destjar', 'buildGraph-pack.jar'
 }