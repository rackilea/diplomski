ServerSocket serversocket; 
boolean foundPort = false;

while (!foundPort)
{
     try {
          serversocket = new ServerSocket(ServerSettings.port); // If this fails, it will jump to the `catch` block, without executing the next line
          foundPort = true;
     }
     catch (IOException io) {
          ServerSettings.port += 505;
     }
}