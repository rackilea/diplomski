try{  
Class cl = Thread.getContextClassLoader().loadClass("com.ibm.websphere.runtime.ServerName");

// found

}  
// not Found  
catch(Throwable)
{

}

// For Tomcat: "org.apache.catalina.xxx"