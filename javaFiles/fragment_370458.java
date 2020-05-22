public class TwoWaySerialComm {

     void connect( String portName ) throws Exception {
     CommPortIdentifier portIdentifier = CommPortIdentifier
      .getPortIdentifier( portName );
        if( portIdentifier.isCurrentlyOwned() ) {
  System.out.println( "Error: Port is currently in use" );
   } else {
  int timeout = 10000;
  CommPort commPort = portIdentifier.open( this.getClass().getName(), timeout );

  if( commPort instanceof SerialPort ) {
    SerialPort serialPort = ( SerialPort )commPort;
    serialPort.setSerialPortParams( 38400,
                                    SerialPort.DATABITS_8,
                                    SerialPort.STOPBITS_1,
                                    SerialPort.PARITY_NONE );

    InputStream in = serialPort.getInputStream();
    OutputStream outputStream = serialPort.getOutputStream();
    outputStream.write( 53 ); 
    outputStream.write( 1 ); 
    outputStream.write( 20 ); 
    outputStream.write( 0 ); 
    outputStream.write( 83 ); 




    CommPort port = serialPort;
    System.out.println( "Write done" );
    ( new Thread( new SerialReader( in,port  ) ) ).start();


  } else {
    System.out.println( "Error: Only serial ports are handled by this example." );
  }
}
  }


  public static class SerialReader implements Runnable {

    InputStream in;
    CommPort serialport;
    public SerialReader( InputStream in, CommPort port) {
      this.in = in;
      serialport = port;
    }

    public void run() {
      byte[] buffer = new byte[ 1024 ];
      int len = -1;

      try {
        while( ( len = this.in.read( buffer ) ) > -1 ) {

            String stringis= new String( buffer, 0, len,"ASCII" );
         //System.out.println( stringis );
         byte[] by_new = stringis.getBytes();
         System.out.println("the lenghth of byte array is "+ by_new.length);
         System.out.println( "The read is " );
         for(int i=0; i<by_new.length; i++) 

            System.out.printf( "%5s",by_new[i]);

         serialport.close();

        }
      } catch( IOException e ) {
        e.printStackTrace();
      }
      try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {System.out.println(e);}
    }
    }



  public static void main( String[] args ) {
    try {
      ( new TwoWaySerialComm() ).connect( "COM2" );

    } catch( Exception e ) {
      e.printStackTrace();
    }
  }
}