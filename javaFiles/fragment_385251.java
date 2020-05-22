apply plugin: 'ear'

evaluationDependsOn ':ACL' // probably not needed

dependencies {
    deploy project(path: ':ACL', configuration: 'publishedWar')
    earlib project(path: ':ACL', configuration: 'shareable')
}  

ear {
    deploymentDescriptor {  
        webModule ('ACL-thin.war', "${project.name}/ACL") // set context root        
    }
}