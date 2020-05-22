String myString;

void setup()
{
   Serial.begin(300);
   //Sets the data rate in bits per second (baud) for serial data transmission. For communicating with the computer, use one of these rates: 300, 600, 1200, 2400, 4800, 9600, 14400, 19200, 28800, 38400, 57600, or 115200. 
   //You can, however, specify other rates - for example, to communicate over pins 0 and 1 with a component that requires a particular baud rate.
}
void loop() 
{  
   while (Serial.available()) 
   {
      myString = Serial.readString();
      //the rest of the code..
   }
}