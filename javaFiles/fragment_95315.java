apply plugin: 'android' // importing the "android" plugin for gradle

buildscript {
    repositories {
        mavenCentral()
    }
    /* 
     * dependencies for your buildscript
     * make sure your buildscript finds the "android" plugin 
     */
    dependencies {      
        classpath 'com.android.tools.build:gradle:0.6.+'
    }
}

/* (external) dependencies for your application */
dependencies {
   compile 'org.apache.ant:ant-commons-net:<your-version>'
}