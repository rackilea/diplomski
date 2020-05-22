test {
    if (project.hasProperty('excludeNotReallyTests')) {
        useJunit {
            excludeCategories 'fully.qualified.name.of.your.NotReallyTests'
        }
    }
}