private static int setPortNumber()
{

    String [] possiblePorts = { "9090", "8080", "8081" }; 
    String selectedPort = (String) JOptionPane.showInputDialog(frame, "Select the Port number for server creation", "Server Connection\n", JOptionPane.OK_CANCEL_OPTION, null, possiblePorts, possiblePorts[0]);

    int PORT = Integer.parseInt(selectedPort);

    return PORT;

}