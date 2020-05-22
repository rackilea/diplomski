private void loader(){
    try
    {
        socket = new Socket(host, PORT);
        inputFromServer = new Scanner(socket.getInputStream());
        outputToServer = new PrintWriter(socket.getOutputStream(),true);

    }
    catch (IOException e)
    {

        e.printStackTrace();
        return;
    }

    if(this.outputToServer == null)
    {
        System.out.println("NULL OUTPUT TO SERVER");
    }
}