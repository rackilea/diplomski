repositories {
    mavenCentral()
    maven { url 'file:path/to/local-repo' } // path is relative to project root
}

dependencies {
    compile 'com.stackoverflow.phillip:my-lib:1.0'
}