public void parseNameInformation(String inputInfo, SecondClass sendData)
{
    //Create an array to store the data and split it into multiple sectors
    String nameInformation[] = inputInfo.split("\\s");

    firstName = nameInformation[0];
    middleName = nameInformation[1];
    lastName = nameInformation[2];

    //System.out.println(firstName + " " + middleName + " " + lastName);

    // SecondClass sendData = new SecondClass();  // !!! get rid of this

    sendData.setFirstName(firstName);
    sendData.setMiddleName(middleName);
    sendData.setLastName(lastName);
}