void myfunction()
{
  {
  // Open serial port
     SerialPort port("COM1", 9600);
     port.doTransfer(data);
  } // Serial port gets closed here.

  for(int i = 0; i < data.size(); i++)
     doProcessData(data[i]);
  etc...
}