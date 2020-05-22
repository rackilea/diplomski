public void successCallback(String arg0, Object arg1) {

    int deviceId = 0;
    int functionCode = 0;
    int productId =0;
    int timeHour = 0;
    int timeMin = 0;
    int dateDay = 0;
    int dateMonth = 0;
    int eventCount = 0;

    System.out.println(arg1);
    receivedData = (String)arg1;    //subscribed data stored 
    System.out.println("DATA :-" + receivedData);
    System.out.println("Message length :  "+receivedData.length());

    for(int i=0; i<receivedData.length(); i++) {
        receivedDataInArray[i] = receivedData.charAt(i);        //Received data converted into array
    }
    .   .   .   .
    .   .   .   .
    .   .   .   .
}