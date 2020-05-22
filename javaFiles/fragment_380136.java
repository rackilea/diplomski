apply plugin: 'java'
processResources {
    from 'src/template/resources', {
        filter(ReplaceTokens, tokens: ['persistence.classes': property('persistence.classes')])
    }
}