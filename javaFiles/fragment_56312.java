defaultConfig {
    // ...
    testInstrumentationRunner 'android.support.test.runner.AndroidJUnitRunner'
}

dependencies {
    compile 'com.android.support:appcompat-v7:23.1.1'
    //compile "com.android.support:cardview-v7:23.1.1"
    //compile "com.android.support:design:23.1.1"
    compile "com.android.support:recyclerview-v7:23.1.1" //THIS IS REQUIRED!
    compile "com.android.support:support-v4:23.1.1"

    // Unit Tests
    testCompile 'junit:junit:4.12'
    testCompile "org.mockito:mockito-all:1.10.19"
    testCompile "org.hamcrest:hamcrest-all:1.3"
    testCompile "org.powermock:powermock-module-junit4:1.6.2"
    testCompile "org.powermock:powermock-api-mockito:1.6.2"

    // Espresso Idling Resource
    compile "com.android.support.test.espresso:espresso-idling-resource:2.2.1"

    // Android Testing Support Library's runner and rules
    androidTestCompile "com.android.support.test:runner:0.4.1"
    androidTestCompile "com.android.support.test:rules:0.4.1"

    // Espresso UI Testing dependencies.
    androidTestCompile("com.android.support.test.espresso:espresso-core:2.2.1") {
        exclude group: 'javax.inject'
    }
    androidTestCompile("com.android.support.test.espresso:espresso-contrib:2.2.1") {
        exclude group: 'javax.inject'
        exclude group: 'com.android.support', module: 'appcompat'
        exclude group: 'com.android.support', module: 'support-v4'
        exclude module: 'recyclerview-v7'
    }
    androidTestCompile "com.android.support.test.espresso:espresso-intents:2.2.1"
}

configurations.all {
    resolutionStrategy.force "com.android.support:support-annotations:23.1.1"
}

configurations.compile.dependencies.each { compileDependency ->
    println "Excluding compile dependency: ${compileDependency.getName()}"
    configurations.androidTestCompile.dependencies.each { androidTestCompileDependency ->
        configurations.androidTestCompile.exclude module: "${compileDependency.getName()}"
    }
}