buildscript {
        repositories {

            mavenCentral()
                /** Ommited project specific config **/

        }


        dependencies {
            classpath 'de.felixschulze.gradle:gradle-spoon-plugin:2.7.3'
        }
    }


    apply plugin: 'com.android.application'
    apply plugin: 'maven'
    apply plugin: 'de.felixschulze.gradle.spoon'

    repositories {
                /** Ommited project specific config **/

        maven { url "htt/jitpack.io" }

        flatDir{
            dirs 'libs'
        }

    }



    android {
        compileSdkVersion 23
        buildToolsVersion "23.0.1"

        packagingOptions {
            exclude 'META-INF/DEPENDENCIES.txt'
            exclude 'META-INF/LICENSE.txt'
            exclude 'META-INF/NOTICE.txt'
            exclude 'META-INF/NOTICE'
            exclude 'META-INF/LICENSE'
            exclude 'META-INF/DEPENDENCIES'
            exclude 'META-INF/notice.txt'
            exclude 'META-INF/license.txt'
            exclude 'META-INF/dependencies.txt'
            exclude 'META-INF/LGPL2.1'
            exclude 'LICENSE.txt'
    //        exclude 'NOTICE.txt'
            exclude 'NOTICE'

        }

        defaultConfig {
            minSdkVersion 14
            targetSdkVersion 23

            multiDexEnabled = true
            testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"


        }


        /*
        Creating flavours. Local is the basic dev mode. QA is built for testing, distributing to QA. Production is the final version
        For Local the crashlytics is disabled. For QA and Production, crashlytics is enabled.
        */
        //Optimizing Multidex Development Builds
        // Dev utilizes minSDKVersion = 21 to allow the Android gradle plugin
        // to pre-dex each module and produce an APK that can be tested on
        // Android Lollipop without time consuming dex merging processes.
        // For more info https://developer.android.com/tools/building/multidex.html#dev-build
        productFlavors {
            QA {
                // The actual minSdkVersion for the application.
                minSdkVersion 14
            }

            Production {
                // The actual minSdkVersion for the application.
                minSdkVersion 14
            }

            Local {
                //Optimizing Multidex Development Builds https://developer.android.com/tools/building/multidex.html#dev-build
                minSdkVersion 21
            }

        }


        signingConfigs {
            /**
             * Uncomment this when you are doing a release build. Make sure you set Env Vars
             */
            release {
                        /** Ommited project specific config **/

            }

            debug {
                        /** Ommited project specific config **/

            }
        }

        buildTypes {
            release {
                minifyEnabled false
                proguardFiles  'proguard-rules.pro'
                /**
                 * Uncomment this when you are doing a release build.
                 */

                /** Ommited project specific config **/


            }

            debug {
                        /** Ommited project specific config **/


            }
        }



        dexOptions {
            jumboMode true
            javaMaxHeapSize "4g"
            incremental true
        }
    }


    spoon {
        debug = true
        failOnFailure = true
        adbTimeout = 2 * 60
        failIfNoDeviceConnected = true
    }

    project.getConfigurations().all { config ->
        if (config.name.contains("AndroidTest")) {
            config.resolutionStrategy.eachDependency { DependencyResolveDetails details ->
                if (details.requested.name == "multidex") {
                    details.useTarget("de.felixschulze.teamcity:teamcity-status-message-helper:1.2")
                }
            }
        }
    }


    dependencies {

        /** Ommited other dependencies **/
        provided fileTree(dir: 'libs', include: ['*.jar'])
        /** *** Google libraries   *****/
        compile 'com.google.code.gson:gson:2.3'
        compile 'com.android.support:appcompat-v7:23.1.1'
        compile 'com.android.support:support-v4:23.1.1'
        compile 'com.android.support:support-v13:23.1.1'
        compile 'com.android.support:cardview-v7:23.1.1'
        compile 'com.android.support:design:23.1.1'
        compile 'com.android.support:multidex:1.0.1'
        compile('com.afollestad.material-dialogs:core:0.8.4.2@aar') {
            transitive = true
        }
        compile 'com.squareup.spoon:spoon-runner:1.3.1'

        debugCompile 'com.google.dexmaker:dexmaker-mockito:1.+'
        debugCompile 'com.google.dexmaker:dexmaker:1.+'
        debugCompile 'org.mockito:mockito-core:1.+'
        debugCompile 'org.hamcrest:hamcrest-core:1.3'
        // Instrumentation testing dependencies
        compile 'com.android.support:support-annotations:23.1.1'
        androidTestCompile 'com.android.support.test.espresso:espresso-core:2.2.1'
        androidTestCompile 'com.android.support.test.espresso:espresso-contrib:2.2.1'
        androidTestCompile 'com.android.support.test:runner:0.4.1'
        androidTestCompile 'com.android.support.test:rules:0.4.1'
        // Unit testing dependencies
        testCompile 'junit:junit:4.12'
        // Memory leak testing dependencies
        debugCompile 'com.squareup.leakcanary:leakcanary-android:1.3.1'
        releaseCompile 'com.squareup.leakcanary:leakcanary-android-no-op:1.3.1'
        // Dependency injection
        compile 'com.google.dagger:dagger:2.0.1'
        apt 'com.google.dagger:dagger-compiler:2.0.1'
        provided 'org.glassfish:javax.annotation:10.0-b28'
        androidTestApt 'com.google.dagger:dagger-compiler:2.0.1'
        compile 'com.google.android.gms:play-services-analytics:8.1.0'
        // Third party libraries

        androidTestCompile 'com.squareup.spoon:spoon-client:1.3.1'
        // Crashlytics Kit

        android {
            lintOptions {
                abortOnError false
            }
        }

    }


    configurations {
        androidTestCompile.exclude group: 'com.android.support', module: 'support-v4'
        androidTestCompile.exclude group: 'com.android.support', module: 'recyclerview-v7'
    }



    configurations.all {
        resolutionStrategy.force 'com.android.support:support-annotations:23.1.1'
    }