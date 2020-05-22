apply plugin: 'me.tatarka.retrolambda'
apply plugin: 'realm-android'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-kapt'
apply plugin: 'realm-android'

kapt 'com.android.databinding:compiler:2.3.3'
compile group: 'com.google.dagger', name: 'dagger', version: "${daggerVersion}"
kapt group: 'com.google.dagger', name: 'dagger-compiler', version: "${daggerVersion}"
kaptTest group: 'com.google.dagger', name: 'dagger-compiler', version: "${daggerVersion}"
kaptAndroidTest group: 'com.google.dagger', name: 'dagger-compiler', version: "${daggerVersion}"