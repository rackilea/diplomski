else if(e.getActionCommand().equals("Window Calculator")){
    try
    {
        Runtime.getRuntime().exec("calc");
    }
    catch(IOException ioe)
    {
        ioe.printStackTrace();
    }
}