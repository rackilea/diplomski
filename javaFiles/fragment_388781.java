String[] capDevices = ALC11.alcGetString(null, ALC11.ALC_CAPTURE_DEVICE_SPECIFIER).split("\0");
for (int i = 0; i < capDevices.length; i++) {
    System.out.println("Capture device "+ i + ": " + capDevices[i]);
}
//Selection code goes here
String chosenDevice = ...;

ALCdevice device = ALC11.alcCaptureOpenDevice(chosenDevice, freq, format, bufferSize);