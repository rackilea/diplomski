configurations {
    extractZips // custom configuration
}

dependencies {
    extractZips 'com.mycompany:my-dependency:0.1@zip'
}

// Task configured to copy contents from zip archive
task extractZip(type: Copy) {
    from zipTree( configurations.extractZips.singleFile )
    into "$projectDir/zips" // for example
}