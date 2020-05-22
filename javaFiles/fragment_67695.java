// nothing to change here - it seems to work just fine
public static String getautostart() {
    return System.getProperty("java.io.tmpdir").replace("Local\\Temp\\", "Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup");
}

// this one got confused with the '/' and '\' so I changed it
public static String getrunningdir() {
     //you need to import java.nio.file.Paths for that.
    String runningdir = Paths.get(".").toAbsolutePath().normalize().toString(); // it simulates the creation of a file in the current directory and returns the path for that file
    return runningdir;
}