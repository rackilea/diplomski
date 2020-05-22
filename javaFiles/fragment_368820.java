try {
    FileWriter writer = new FileWriter("testResult.csv");
    writer.append(createdUser);
    writer.append(',');
    writer.append(testResult); //whatever String this is
    writer.flush();
    writer.close();
catch (IOException ex) {
    //handle exception somehow    
}