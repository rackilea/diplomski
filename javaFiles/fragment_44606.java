appengine {
    downloadSdk = true
    httpPort = 8080

    sourceSets {
        main {
            java.srcDirs = ['src']
            test.java.srcDirs = ['test']
        }
    }

    appcfg {
        email = 'xxxx.xxxxxx@xxxxx.com'
        passIn = true

        logs {
            severity = 1
            outputFile = file('mylogs.txt')
        }

        app {
            id = 'wordbuzzweb'
        }
    }

    dependencies {
        compile project(":comms")

        appengineSdk "com.google.appengine:appengine-java-sdk:$appEngineVersion"
        compile "com.google.appengine:appengine-api-1.0-sdk:$appEngineVersion"
        compile "com.google.appengine:appengine-endpoints:$appEngineVersion"
        compile "com.google.appengine:appengine-endpoints-deps:$appEngineVersion"

        compile "com.googlecode.objectify:objectify:5.1.1"
        compile group: "com.google.guava", name: "guava", version: "18.0"

        testCompile group: "junit", name: "junit", version: "4.11"
        testCompile "com.google.appengine:appengine-testing:$appEngineVersion"
        testCompile "com.google.appengine:appengine-api-labs:$appEngineVersion"
        testCompile "com.google.appengine:appengine-api-stubs:$appEngineVersion"

        compile "javax.servlet:servlet-api:2.5"
    }
}