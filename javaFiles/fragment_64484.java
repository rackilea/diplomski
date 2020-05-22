import javax.naming.Context
import javax.naming.InitialContext
try {
  Context appCtx = (Context)(new InitialContext().lookup("java:app"))

  // JBoss's deployment name
  // you can see this at Profile >> Container >> Naming >> applications
  deploymentName = appCtx.lookup("AppName")

  grails.config.locations << "classpath:${deploymentName}-config.properties"
  grails.config.locations << "classpath:${deploymentName}-config.groovy"
  if(System.properties["${deploymentName}.config.location"]) {
    grails.config.locations << "file:" +
      System.properties["${deploymentName}.config.location"]
  } else if(System.getenv("${deploymentName}.config.location")) {
    grails.config.locations << "file:" + 
      System.getenv("${deploymentName}.config.location")
  }
}catch(Exception ex) {
  // Initial Context does not exist
  // aka, not deployed
}