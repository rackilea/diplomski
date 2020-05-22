buildscript {
    repositories {
<#if mavenUrl == "mavenCentral">
        mavenCentral()
<#else>
        maven { url '${mavenUrl}' }
</#if>
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:${gradlePluginVersion}'
    }
}
apply plugin: 'android'

repositories {
<#if mavenUrl == "mavenCentral">
    mavenCentral()
<#else>
    maven { url '${mavenUrl}' }
</#if>
}

android {
    compileSdkVersion ${buildApi}
    buildToolsVersion "${buildToolsVersion}"

    defaultConfig {
        minSdkVersion ${minApi}
        targetSdkVersion ${targetApi}
    }
}

dependencies {   /// ADD YOUR DEPENDENDENCIES HERE
    compile 'com.android.support:support-v4:${v4SupportLibraryVersion}'
    compile 'com.android.support:recyclerview-v7:25.1.1' //add your dependancies here
    compile 'com.squareup.picasso:picasso:2.5.2' 
    compile 'com.jakewharton:butterknife:8.5.1'
    apt 'com.jakewharton:butterknife-compiler:8.5.0'
    compile 'com.squareup.okhttp3:okhttp:3.6.0'
    compile 'com.facebook.stetho:stetho-okhttp3:1.4.2'
}

allprojects {
    repositories {
        jcenter()
<#if mavenUrl != "mavenCentral">
        maven {
            url '${mavenUrl}'
        }
</#if>
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}