apply plugin: 'java'

sourceSets {
    main {
        java {
            srcDir = ['src']
            exclude "main/*"
            exclude "hello/*"
            exclude "test/*"
        }
    }
}