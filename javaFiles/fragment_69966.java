Workflow {

bean = org.eclipse.emf.mwe.utils.StandaloneSetup {
    platformUri=".."
}

component = org.eclipse.emf.mwe.utils.DirectoryCleaner {
    directory ="src/main/java/sample"
}

component = org.eclipse.emf.mwe2.ecore.EcoreGenerator {
    generateCustomClasses = false
    genModel = "platform:/resource/org.xtext.example.mydsl3/model/sample.genmodel"
    srcPath = "platform:/resource/org.xtext.example.mydsl3/src/main/java" 
}
}