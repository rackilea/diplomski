test {
    useJUnitPlatform {
        excludeTags 'PR'
    }
}

task prTest(type: Test) {
    useJUnitPlatform {
        includeTags 'PR'
    }
    shouldRunAfter test
}