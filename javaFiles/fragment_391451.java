android {
     ...
     sourceSets {
            main {
                //....
                res.srcDirs = ['/src/main/res']

            }
            flavorA1 {
                 res.srcDirs = ['/src/flavor1/res', '/src/commonA/res']
            }
            flavorA2 {
                 res.srcDirs = ['/src/flavor2/res', '/src/commonA/res']
            }     
            //.....other flavors   
     }
}