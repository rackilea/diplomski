// set up the kotlin-gradle plugin
buildscript {
    ext.kotlin_version = '1.1.60'
    repositories {
       mavenLocal()    //    mavenCentral()
    }
    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}

// apply the kotlin-gradle plugin
apply plugin: "kotlin"

// add kotlin-stdlib dependencies.
repositories {
    mavenLocal()  //  mavenCentral()
}

dependencies {
    //dependencies from a remote repositor
    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"

  //local file, that are not coming from repository, let's say my own jar files
  compile files('libs/Display.jar')
  compile fileTree(dir: 'libs', include: '*.jar')
}

jar {
    manifest {
        //Define mainClassName as: '[your_namespace].[your_arctifact]Kt'
        attributes ('Main-Class': 'MainKt', "Implementation-Title": "Gradle",
                   "Implementation-Version": 1)
    }
    // NEW LINE HERE !!!
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
}

sourceSets {
    main.kotlin.srcDirs += 'src/kotlin'
    main.resources.srcDirs += 'src/resources'
}

kotlin {
    experimental.coroutines 'enable'
}

compileKotlin {
    kotlinOptions.jvmTarget= 1.8  // optional, Minimum jvmTarget of 1.8 needed since Kotlin 1.1
    kotlinOptions.suppressWarnings = true
}