task checkUnescapedApostrophes {
    doFirst {

        println("checkUnescapedApostrophes")

        fileTree("src").matching {
            include "**/strings.xml"
        }.each {
            def stringsFile = it
            def parser = (new XmlParser()).parse(stringsFile)
            println("Processing file: "+stringsFile)
            parser.'string'.each { m ->
                def s = m.text()
                def ss = "[^\\\\]\'"
                println "[" + m.@name + "]: " + s
                if (s =~ ss) {
                    throw new GradleException(
                        "Found a string value in " + stringsFile + 
                        " have unescaped apostrophe: "+s)
                }
            }
        }
        println("strings.xml OK")
    }
}

preBuild.dependsOn(checkUnescapedApostrophes)