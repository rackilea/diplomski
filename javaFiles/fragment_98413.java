// Get current context class loader
ClassLoader contextLoader = Thread.currentThread().getContextClassLoader(); 
// Change context classloader to class context loader   
Thread.currentThread().setContextClassLoader(AzureManagementServiceDelegate.class.getClassLoader)); 
try { 
     // Call Azure API and reset back the context loader 
} catch (Exception e) {
    // handle exceptions  
} finally {
 // Reset back class loader
Thread.currentThread().setContextClassLoader(contextLoader); 
}