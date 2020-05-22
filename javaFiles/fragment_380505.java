import my.library.SomeThing
import my.library.SomeOtherThing

buildscript {
    ext.libraryVersion = "1.0.1"

    repositories {
        maven { url "http://some.url.com" }
    }

    dependencies {
        classpath "my.gradle.plugin:gradle-plugin:1.0.0"
        classpath "my.library:my-library:$libraryVersion"
    }
}

apply plugin: 'my-plugin-id' //No need to use FQN

ext.SomeThing = SomeThing
ext.SomeOtherThing = SomeOtherThing

dependencies {
    compile "my.library:my-library:$libraryVersion"
}

apply from: 'gradle/other.gradle'