android {

           defaultConfig {
                multiDexEnabled true
           }


           dexOptions {
                incremental true
                javaMaxHeapSize "4g"
           }

   }