project(":android") {
    apply plugin: "android"

    configurations { natives }

    dependencies {
        compile project(":core")
        compile project(":libraries:BaseGameUtils")
        compile "com.badlogicgames.gdx:gdx-backend-android:$gdxVersion"
        natives "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-armeabi"
        natives "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-armeabi-v7a"
        natives "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-x86"
        compile "com.badlogicgames.gdx:gdx-box2d:$gdxVersion"
        natives "com.badlogicgames.gdx:gdx-box2d-platform:$gdxVersion:natives-armeabi"
        natives "com.badlogicgames.gdx:gdx-box2d-platform:$gdxVersion:natives-armeabi-v7a"
        natives "com.badlogicgames.gdx:gdx-box2d-platform:$gdxVersion:natives-x86"
        compile "com.badlogicgames.gdx:gdx-freetype:$gdxVersion"
        natives "com.badlogicgames.gdx:gdx-freetype-platform:$gdxVersion:natives-armeabi"
        natives "com.badlogicgames.gdx:gdx-freetype-platform:$gdxVersion:natives-armeabi-v7a"
        natives "com.badlogicgames.gdx:gdx-freetype-platform:$gdxVersion:natives-x86"
        compile 'com.android.support:appcompat-v7:20.0.+'
        compile 'com.android.support:support-v4:20.0.+'
        compile 'com.google.android.gms:play-services:5.0+'
    }

}