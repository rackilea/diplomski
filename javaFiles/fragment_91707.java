distributions {
    main {
        baseName = "Something"
        contents {
            into('bin') { from jar.archivePath }
            into('lib') { from configurations.runtime }
            into('etc') {
                from project(':projB').file('src/main/webapp')                
                from project(':projB').resourcesDir
            }
        }
    }
}