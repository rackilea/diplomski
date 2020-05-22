SerialPort serialPort;
InputStream inStream;
OutputStream outStream;

serialPort = (SerialPort) portId.open(...);
serialPort.setFlowControlMode(...);
serialPort.setSerialPortParams(...);

inStream = serialPort.getInputStream ();
outStream = serialPort.getOutputStream ();