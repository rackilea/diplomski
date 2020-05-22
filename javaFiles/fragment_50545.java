String os = System.getProperty("os.name").toLowerCase();
SerialPort serialPortImpl;
if (os.substring("windows") != -1) {
   // use windows serial port class
   serialPortImpl = serialPortWindows; 
} else {
   // use linux serial port class
   serialPortImpl = serialPortLinux;     
}

// now use serialPortImpl, it contains relevant implementation
// according to the current operating system