group 'com.scrap'
version '1.0-SNAPSHOT'

apply plugin: 'java'

sourceCompatibility = 1.5

repositories {
    mavenCentral()
}

dependencies {
    compile group: 'com.yahoofinance-api', name: 'YahooFinanceAPI', version: '3.5.0' //Changed version
    compile 'joda-time:joda-time:2.2'
    testCompile group: 'junit', name: 'junit', version: '4.11'
}

// Added new section
jar {
    from {
        (configurations.runtime).collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }
    manifest {
        attributes("Main-Class": "Main" )
    }
}