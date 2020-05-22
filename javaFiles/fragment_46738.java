String[] cmdLineInput = { "C:\\ExifTool\\exif.exe", "-ee",
        "C:\\images\\example.tif" };
ProcessBuilder processBuilder = new ProcessBuilder(cmdLineInput);
Process exif; // = processBuilder.start();

/**
 * CmdLineIpnut[1] = Fully qualified path to exiftool CmdLineIpnut[2] =
 * -ee // ( extract embedded ) option to extract data from multipaged
 * .tif files. CmdLineIpnut[3] = Fully qualified path to .tif file.
 */

String outputLine = "";

try {
    exif = processBuilder.start();
    BufferedReader brInput = new BufferedReader(new InputStreamReader(
            exif.getInputStream()));

    while ((outputLine = brInput.readLine()) != null) {
        System.out.println(outputLine);

    }
    exif.waitFor();

} catch (IOException ioe) {
    // handle exeception
}