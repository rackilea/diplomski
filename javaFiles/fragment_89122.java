apply plugin: 'java'

repositories {
    mavenCentral()
}

configurations {
    cucumber
}

dependencies {
    cucumber 'info.cukes:cucumber-java:1.2.2'
}

task runCucumber(type: JavaExec) {
    main = "cucumber.api.cli.Main"
    args += ['-f', 'html:build/reports/cucumber/', '-f', 'json:build/reports/cucumber/report.json', '--glue', 'com.waze.testing.cucumber', 'src/main/resources/features'
             , '--tags', '~@ignore', '--tags', '~@preRelease', '--tags', '@advil']
    systemProperties['http.keepAlive'] = 'false'
    systemProperties['http.maxRedirects'] = '20'
    ignoreExitValue = true
    classpath = configurations.cucumber
}