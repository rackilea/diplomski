apply plugin: 'com.bmuschko.clover'

evaluationDependsOn ':someOtherProject'    
clover {
    additionalSourceDirs = project(':someOtherProject').sourceSets.main.allSource.srcDirs
}