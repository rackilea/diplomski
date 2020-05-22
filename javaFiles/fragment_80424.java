project(":core") {
apply plugin: "java"

dependencies {
    compile "com.badlogicgames.gdx:gdx:$gdxVersion"
    compile "com.badlogicgames.gdx:gdx-box2d:$gdxVersion"
    // add firebase
    compile 'com.firebase:firebase-client:1.0.16'
}