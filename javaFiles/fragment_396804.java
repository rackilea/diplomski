public String getChassisSerialNumber()
{
    File myFile = new File("/sys/devices/virtual/dmi/id/chassis_serial");
    if (myFile.exists()) 
    {          
        byte[] fileBytes;
        try {
            fileBytes = Files.readAllBytes(myFile.toPath());
        } catch (java.nio.file.AccessDeniedException e) {
            return null;
        }

        if (fileBytes != null && fileBytes.length > 0) 
        {
            return new String(fileBytes);
        } 
    } 
    return null;
}