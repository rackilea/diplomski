/* replace XXXX by the name of the
   class that holds method `ReadCPUMhz()`
*/
XXX instance = new XXX(); // supposing class XXX has such a constructor
String result = instance.ReadCPUMhz().trim(); // removes leading & trailing spaces
int kHzValue = Integer.parseInt(result); // result in kHz
int MHzResult = kHzValue / 1000; // result in MHz