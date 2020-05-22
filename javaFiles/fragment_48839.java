apply plugin: 'kotlin-kapt'

dependencies {
  ...
  implementation 'com.github.matthiasrobbers:shortbread:1.0.2'
  kapt 'com.github.matthiasrobbers:shortbread-compiler:1.0.2'
}