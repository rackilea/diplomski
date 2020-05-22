flavorDimensions "abi", "version"  //this is what can help you build with/w/o jni libraries

    productFlavors {
        devel {
            flavorDimension "abi" //keep a dimension common with arm, armv7
            applicationId "com.packagename.dev"
        }
        prod {
       flavorDimension "version"
    // this would be your build w/o the ndk support then
            applicationId "com.packageName"
        }
        armv7 {
            ndk {
                flavorDimension "abi"
                abiFilter "armeabi-v7a"
            }
        }
        arm {
            ndk {
                flavorDimension "abi"
                abiFilter "armeabi"
            }
        }

    }