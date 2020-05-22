Thread.sleep(1000); // wait for it to connect    
sendCommand("sudo su"); // the command I tried
Thread.sleep(1000); // not sure how long you need to wait
sendCommand("mypassword");
Thread.sleep(1000);
// etc.