if ( commPort instanceof SerialPort )
        {
            SerialPort serialPort = (SerialPort) commPort;
            serialPort.setSerialPortParams(115200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
            InputStream in = serialPort.getInputStream();
            OutputStream out = serialPort.getOutputStream();
out1=out;  //add this line, where out1 is a global variable//  
            (new Thread(new SerialReader(in))).start();
         (new Thread(new SerialWriter(out))).start();

        }