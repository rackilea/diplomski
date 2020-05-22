public static String executeCommand(List<String> commands)
            throws IOException {
        ProcessBuilder builder = new ProcessBuilder(commands);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        return r.readLine();
    }

//this command gives the current installed path of Firefox in c drive 
String[] getInstalledFirefoxDirectoryCmd = { "cmd.exe", "/c", "dir /s/b \"C:/firefox.exe\""};

String installedFirefoxLocation = executeCommand(Arrays.asList(getInstalledFirefoxDirectoryCmd));

//this command will give version of the installed Firefox
String[] getFirefoxVersionCmd = { "cmd.exe", "/c", "\"" + installedFirefoxLocation + "\" -v | more" };

String version = executeCommand(Arrays.asList(getFirefoxVersionCmd));

int version_int = Integer.parseInt(version.replace("Mozilla Firefox ", "").split("\\.")[0]);

URL server = new URL("http://localhost:4444/wd/hub")
DesiredCapabilities capabilities = DesiredCapabilities.firefox();

//use marionette if ff version equal or greater than 47
if(version_int >= 47) {
     capabilities.setCapability("marionette", true);
}

WebDriver webDriver = new RemoteWebDriver(server, capabilities);
webDriver.get("https://www.google.co.in");