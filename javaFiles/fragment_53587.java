public enum BtnWifi { // you can create new enum java file for this
 CONNECTED, NOT_CONNECTED
}
//.... Setting value for enum in your code
BtnWifi btnWifi;
if(isConnected) {
//if connection established 
   btnWifi = BtnWifi.CONNECTED;
} else {     
   btnWifi = BtnWifi.NOT_CONNECTED;
}
// No switch to use it...
switch(btnWifi) {
  case CONNECTED:
     //code for connected...
   break;
  case NOT_CONNECTED:
     //code for Not connected...
   break;
}