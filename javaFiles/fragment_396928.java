repositories {
            maven { url 'https://plugins.gradle.org/m2/'}
        }
        dependencies {
            classpath 'gradle.plugin.com.onesignal:onesignal-gradle-plugin:[0.12.4, 0.99.99]'
        }
    }
    apply plugin: 'com.onesignal.androidsdk.onesignal-gradle-plugin'

    repositories {
        maven { url 'https://maven.google.com' }
    }