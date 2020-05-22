war {
    eachFile { copyDetails ->
        if (copyDetails.path == 'index.html') {
            filter { line ->
                line.replace('{{app javascript library}}', "lib/someLib.js")
            }
        }
    }
}