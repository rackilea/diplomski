@Override
public void serialEvent(SerialPortEvent event) {
        switch(event.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;
            case SerialPortEvent.DATA_AVAILABLE:
                StringBuffer readBuffer = new StringBuffer();
                int c;
                try{

                    while ((c=inputStream.read()) != 10){
                        if(c!=13 && c != 1){
                            readBuffer.append((char) c);
                        }
                    }
                    String scannedInput = readBuffer.toString();

                        /*
                    DO YOUR THING HERE     
                        */  

                } catch (IOException e) {}

                break;
        }
}