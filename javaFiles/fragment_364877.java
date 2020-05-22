osgi> ss

Framework is launched.

id State       Bundle
0 ACTIVE      org.eclipse.osgi_3.4.0.v20080605-1900

osgi>  install file:bundles/FirstBundle-1.0.0.jar
Bundle id is 1

//Try starting 
osgi> start 1
org.osgi.framework.BundleException: The bundle could not be resolved. 
  Reason: Missing Constraint: Import-Package: com.so.samples.osgi.second; 
                                              version="0.0.0"
 at org.eclipse.osgi.framework.internal.core.BundleHost.startWorker
    (BundleHost.java:305)