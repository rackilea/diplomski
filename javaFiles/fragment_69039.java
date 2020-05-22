void loop(){

    if(client){

        if(millis() >= (lastSendt + 15000)){
            sendCharacter('*')
        }

        if(client.available()){

            char c = client.read();

            if(c != '\n'){
                message += c;
            }
            else{
                Serial.println("Received message: "+message);
                checkMessage();
                sendMessage(message);
                message = "";
            }
        }
    }
}