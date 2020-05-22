volatile String valueIAmWaitingFor; // Class Variable
...

while(valueIAmWaitingFor == null){ 
     Thread.sleep(3000); 
}
//go on