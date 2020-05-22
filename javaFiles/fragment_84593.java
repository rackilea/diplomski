String result = getString(R.string.not_charging);
String resultusb = getString(R.string.usb_no);

--
--

if (isCharging) {
 result = getString(R.string.is_charging);
} 

if (usbCharge){
 resultusb = getString(R.string.usb_yes);
}