plugins {
  id 'io.ratpack.ratpack-groovy' version '1.3.3' // downloads ratpack-groovy 1.3.3 which is latest as of 2016-05-12
  id 'idea' // new way of applying idea plugin
}

group 'pl.edu.agh.tai.tdo'
version '1.0'

repositories {
    maven { url "http://oss.jfrog.org/repo" }
    mavenCentral()
    maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
    jcenter()
}

mainClassName = "pl.edu.agh.tai.tdo.Main"

dependencies {
    compile ratpack.dependency('handlebars') // use ratpack gradle plugin to ensure that ratpack-handlebars 1.3.3 is used
    compile ratpack.dependency('pac4j') // use ratpack gradle plugin to ensure that ratpack-pac4j 1.3.3 is used

    runtime "org.slf4j:slf4j-simple:1.7.12"
    compile "com.heroku.sdk:heroku-jdbc:0.1.1"
    compile "org.postgresql:postgresql:9.4-1201-jdbc4"
    compile "org.jscience:jscience:4.3.1"

    compile 'org.twitter4j:twitter4j-core:4.0.4'
    compile 'ch.qos.logback:logback-classic:1.1.7'

    testCompile group: 'junit', name: 'junit', version: '4.11'
}

task stage(dependsOn: installDist)