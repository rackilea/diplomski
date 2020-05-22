apply plugin: 'android'                                                                              

repositories {                                                                                       
    mavenCentral()                                                                                   
}                                                                                                    

dependencies {                                                                                       
    compile fileTree(dir: 'libs', include: '*.jar')                                                  
    compile project(':google-play-services_lib')                                                     
    compile project(':facebook-sdk_lib')                                                             


    compile ('de.greenrobot:greendao:1.3.7'){                                                        
       exclude group: 'org.hamcrest'                                                                 
    }                                                                                                

    androidTestCompile('org.mockito:mockito-core:1.9.5'){                                            
        exclude group: 'org.hamcrest'                                                                
    }                                                                                                

    androidTestCompile('org.powermock:powermock-module-junit4:1.5'){                                 
        exclude group: 'org.hamcrest'                                                                
    }                                                                                                
}                                                                                                    

android {                                                                                            

    packagingOptions {                                                                               
        exclude 'META-INF/ASL2.0'                                                                    
        exclude 'META-INF/LICENSE'                                                                   
        exclude 'META-INF/LICENSE.txt'                                                               
        exclude 'META-INF/NOTICE'                                                                    
        exclude 'META-INF/NOTICE.txt'                                                                
    }                                                                                                

    compileSdkVersion 19                                                                             
    buildToolsVersion "19.1.0"                                                                       

    lintOptions {                                                                                    
        abortOnError false                                                                           
    }                                                                                                

    sourceSets {                                                                                     
        main                                                                                         
        {                                                                                            
            manifest.srcFile 'AndroidManifest.xml'                                                   
            resources                                                                                
            {                                                                                        
                srcDir 'src-gen'                                                                     
            }                                                                                        
            aidl.srcDirs = ['src/main/java', 'src-gen']                                              
            renderscript.srcDirs = ['src/main/java', 'src-gen']                                      
            res.srcDirs = ['res']                                                                    
            assets.srcDirs = ['assets']                                                              
            java.srcDirs = ['src/main/java', 'src/main/java/', 'src-gen']                            
        }                                                                                            

        androidTest {                                                                                
            java.srcDirs = ['tests']                                                                 
        }                                                                                            


        unitTest {                                                                                   
            java.srcDir file('tests')                                                                
            resources.srcDir file('tests/res')                                                       
        }                                                                                            


        debug.setRoot('build-types/debug')                                                           
        release.setRoot('build-types/release')                                                       
    }//-End of sourceSet                                                                             
}  //-End of android