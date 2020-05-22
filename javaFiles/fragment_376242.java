apply plugin: 'kotlin-kapt'
android{
  kapt {
        generateStubs = true
    }
}
dependencies {
    //Dagger
    kapt 'com.squareup.dagger:dagger-compiler:1.2.2'
}