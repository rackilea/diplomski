plugins {
    id 'java'
    id 'application'
    id 'cpp'
}

repositories {
    jcenter()
}

dependencies {
    implementation 'com.google.guava:guava:28.0-jre'
    testImplementation 'junit:junit:4.12'        
}

application {
    mainClassName = 'demo.App'
}
run {
    systemProperty "java.library.path", file("${buildDir}/libs/nativeCpp/shared").absolutePath
}
model {
    platforms {
        x64 {
            architecture "x64"
        }
    }

    components {
        nativeCpp(NativeLibrarySpec) {


            binaries.all {
                cppCompiler.args '-I', "${org.gradle.internal.jvm.Jvm.current().javaHome}/include"
                cppCompiler.args '-I', "${org.gradle.internal.jvm.Jvm.current().javaHome}/include/linux"
                cppCompiler.args '-fPIC'
            }

        }
    }
}

run.dependsOn  'nativeCppSharedLibrary'