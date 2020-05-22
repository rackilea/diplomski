apply plugin: 'idea'
idea {
    module {
        sourceDirs += file('build/generated/source/kapt/main')
        generatedSourceDirs += file('build/generated/source/kapt/main')
    }
}