apply plugin: 'java'

sourceCompatibility = 1.7
version = '1.0'

repositories {
    mavenCentral()
}

dependencies {
    testCompile 'org.testng:testng:6.8.21'
}

test {
    useTestNG() {
        includeGroups 'simple'
    }
}