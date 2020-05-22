apply plugin: 'java'

/* We use Java 1.8 */
sourceCompatibility = 1.8
targetCompatibility = 1.8
version = '1.0'

repositories { mavenCentral() }

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.11'
    compile "com.almworks.sqlite4java:sqlite4java:1.0.392"
    compile "com.almworks.sqlite4java:libsqlite4java-osx:1.0.392"
}

sourceSets {
    main {
        java.srcDir 'src'
        output.classesDir = 'build/main'
    }
    test {
        java.srcDir 'test'
        output.classesDir = 'build/test'
    }
}

/* Copy the native files */
task copyNativeDeps(type: Copy) {
    from (configurations.compile+configurations.testCompile) {
        include "*.dylib"
    }
    into 'build/libs'
}

/* Make sure we setup the tests to actually copy 
 * the native files and set the paths correctly. */
test {
    dependsOn copyNativeDeps
    systemProperty "java.library.path", 'build/libs'
}