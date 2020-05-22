String pathToPhpExecutable = getFileDir() + "/php-cgi";
String phpFile = getFileDir() + "/php/myPhpFile.php";

Process process = new ProcessBuilder()
.command(pathToPhpExecutable, phpFile)
.redirectErrorStream(true)
.start();

try {
    InputStream in = process.getInputStream();
    // Read the input stream and i.e. display the results in a WebView
} finally {
    process.destroy();
}