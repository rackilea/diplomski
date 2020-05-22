SerialPort serialPort = new SerialPort("/dev/ttyUSB0");// For windows "COMX" (e.g : "COM1") should works
if (serialPort.openPort()) {
    serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_ODD);
    byte[] buffer = serialPort.readBytes(1);// Read one byte
    String str = new String(buffer);
    serialPort.closePort();
}