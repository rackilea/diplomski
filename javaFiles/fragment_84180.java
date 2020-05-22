String received = new String(dgram.getData());  
String dataReceived = "";
for(int i = 0;i<received.lenght();i++){

char charac = received.charAt(i);//this will allow you to get all data in String
switch(charac){

    case 'a': dataReceived = dataReceived.concat(String.valueOf(charac));
    case 'b': dataReceived = dataReceived.concat(String.valueOf(charac));
    case 'c': dataReceived = dataReceived.concat(String.valueOf(charac));
    case 'd': dataReceived = dataReceived.concat(String.valueOf(charac));
    ...
    case '1': dataReceived = dataReceived.concat(String.valueOf(charac));
    case '2': dataReceived = dataReceived.concat(String.valueOf(charac));
    ...
    case '.': dataReceived = dataReceived.concat(String.valueOf(charac));
    case ',': dataReceived = dataReceived.concat(String.valueOf(charac));
    ..          
   }
 } 
System.out.println("Data Received: "+dataReceived);