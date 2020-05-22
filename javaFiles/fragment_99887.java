// scripts/_Events.groovy
eventCompileStart = { args ->
    if (Boolean.valueOf(System.getProperty('in.generate', "false"))) {
        // skip
    } else {
        ['bash', '-c', 'yes | grails -Din.generate=true generate-dto --all'].execute()
    }
}