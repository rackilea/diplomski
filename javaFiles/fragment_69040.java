void sendCharacter(char toSend){

    if(client){
        client.println(toSend){
        lastSendt = millis();
    }else{
        Serial.println("Could not send character!");
    }
}