processResources {
    inputs.file file('gradle.properties')
    filter(
            ReplaceTokens, 
            tokens: [
                    greeting: project.ext.greeting
            ]
    )