void loop() 
{
  Serial.println ("Position " + array[i]);
  delay (2000);
  for ( ; i <= 50; ) 
  {
    int n = random (251); // Random number from 0 to 250
    array[i] = n;
    i++;
  }
}