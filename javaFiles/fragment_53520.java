public class GPScom implements SerialPortEventListener
{
    private String portcom;
    private CommPortIdentifier portid=null; 
    private SerialPort serialport; 
    private BufferedReader fluxgps; // Reading flow port where the GPS is connected

        public static void main(String[]args)
    {
        // Driver initialization
        Win32Driver driver=new Win32Driver();
        driver.initialize();

        GPScom gpscom=new GPScom();
        gpscom.listPort();
    }

    // Scanning all available ports
    public void listPort()
    {
        Enumeration listport=CommPortIdentifier.getPortIdentifiers();
        int typeport;
        String GPSPortCOM;

        while(listport.hasMoreElements())
        {
            portid=(CommPortIdentifier)(CommPortIdentifier)listport.nextElement();
            if(portid.getPortType()==CommPortIdentifier.PORT_SERIAL)
            {
                System.out.println("Port Name : "+portid.getName());
                System.out.println("User : "+portid.getCurrentOwner());
                System.out.println("Use ? : "+portid.isCurrentlyOwned());
                System.out.println("Port type : "+portid.getPortType());

                this.ModeEvenement(portid.getName());
            }
        }
    }

    // Initialization of the port
    public void ModeEvenement(String portcom)
    {
        // Retrieve ID Port
        try{portid=CommPortIdentifier.getPortIdentifier(portcom);}
        catch(NoSuchPortException e){System.out.println(e);}

        // Open Port
        try{serialport=(SerialPort)portid.open("ModeEvenement",2000);}
        catch(PortInUseException e){System.out.println(e);}

        // Retrieve data flow
        try{fluxgps=new BufferedReader(new InputStreamReader(serialport.getInputStream()));}
        catch(IOException e){System.out.println(e);}

        // Add listener
        try{serialport.addEventListener(this);}
        catch(TooManyListenersException e){System.out.println(e);}

        // Configure Port
        serialport.notifyOnDataAvailable(true);
        try{serialport.setSerialPortParams(4800, SerialPort.DATABITS_6, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);}
        catch(UnsupportedCommOperationException e){System.out.println(e);}

        System.out.println("Port is open, waiting for the reading");
    }

    // Here we are reading 7 frames for test
    public void ReadSerialPort()
    {
        int i=7;
        String reponse=new String();

        try
        {
            System.out.println("i="+i);
            while(i!=0)
            {
                System.out.println("Reading the COM port \n");
                reponse=(String)fluxgps.readLine();
                System.out.println(reponse);
                i--;
                System.out.println("i="+i);
            }           
        }
        catch(IOException e){System.out.println(e);}

        // On ferme le flux de lecture
        try{fluxgps.close();}
        catch(IOException e){System.out.println(e);}

        serialport.close();
    }

    public void serialEvent(SerialPortEvent event)
    {
        // We are only reading data if available
        switch(event.getEventType())
        {
            case SerialPortEvent.DATA_AVAILABLE:
                this.ReadSerialPort(); // Launching the reading if data are available
                break;
            default:
                break; // Else, do nothing
        }
    }   
}