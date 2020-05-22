public boolean checkLogin(String userName, String password) throws IOException {

    BufferedReader bufferedReader = 
        new BufferedReader(new FileReader("D:\\data.txt"));

    String line;
    String[] currentPair;
    while((line = bufferedReader.readLine()) != null)
    {
        currentPair = line.split(":");
        if(currentPair[0].equals(userName) && currentPair[1].equals(password))
        {
            return true;
        }
    }
    return false;
}