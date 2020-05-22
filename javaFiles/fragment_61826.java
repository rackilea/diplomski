try { 
    server.start();
    reportingAvailable = true;
} catch ( Exception e ) { 
    log("Jetty failed to start. Reporting will we unavailable", e);
}