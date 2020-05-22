apply plugin: 'com.android.application'
android {
    ...
    defaultConfig {
        ...
        jackOptions {
            enabled true
            jackInProcess false
        }
    }
}

compileOptions {
    targetCompatibility JavaVersion.VERSION_1_8
    sourceCompatibility JavaVersion.VERSION_1_8
    incremental false
}

//it needs to translate the Java 8 code we write in the Java 7/ Java 6 bytecode Android understands:
retrolambda {
    jdk System.getenv('JAVA8_HOME')
    oldJdk System.getenv('JAVA7_HOME')
    jvmArgs '-arg1', '-arg2'
    defaultMethods false
   incremental true
}