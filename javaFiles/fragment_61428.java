String platform = System.getProperty("microedition.platform");
platform = platform.toUpperCase();
if ((platform.indexOf("J2ME") != -1) || (platform.equalsIgnoreCase("SunMicrosystems_wtk"))) {
 //EMULATOR
}else {
//Device
}