apply plugin: 'com.android.model.library'

...

model {

    android {
      ...
      ndk {
          moduleName = "library-jni"
          cppFlags.add("-std=c++11")
          cppFlags.add("-fexceptions")
          stl = "c++_static"

          abiFilters.addAll(['armeabi-v7a', 'x86']) // supported abis only
       }
       ...
    }
    ...
}