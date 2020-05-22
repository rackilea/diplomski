project(":desktop") {
apply plugin: "java"


dependencies {
    compile project(":core")
    compile "com.badlogicgames.gdx:gdx-backend-lwjgl:$gdxVersion"
    compile "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop"
    compile fileTree(dir: '../core/libs', include: '*.jar')
    compile fileTree(dir: 'libs', include: '*.so')
    compile fileTree(dir: 'libs', include: '*.jar')
}
}

project(":android") {
apply plugin: "android"

configurations { natives }

dependencies {
    compile project(":core")
    compile "com.badlogicgames.gdx:gdx-backend-android:$gdxVersion"
    natives "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-armeabi"
    natives "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-armeabi-v7a"
    natives "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-arm64-v8a"
    natives "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-x86"
    natives "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-x86_64"
    compile fileTree(dir: '../core/libs', include: '*.jar')
    compile fileTree(dir: 'libs', include: '*.so')
}
}

project(":core") {
apply plugin: "java"


dependencies {
    compile "com.badlogicgames.gdx:gdx:$gdxVersion"
    compile fileTree(dir: 'libs', include: '*.jar')
}
}