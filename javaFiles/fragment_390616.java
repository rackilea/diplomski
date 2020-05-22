apply plugin: 'java'

repositories {
   mavenCentral()
}

dependencies {
   compile "org.apache.pig:pig:0.13.0:h2"
}

task copyDeps(type: Copy) {
   from configurations.compile
   into 'deps'
}