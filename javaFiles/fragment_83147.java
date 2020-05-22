public class ChromeLocator {
    private static final Logger log = Logger.getLogger(ChromeLocator.class);

/**
 * Obtain Chrome Configuration with location of binary
 * @return
 * @throws IOException
 */
public DesiredCapabilities getCapabilities() throws IOException {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setBinary(getChromeExecutableLocation().getAbsolutePath());
    chromeOptions.addArguments("no-sandbox");
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);


    return capabilities;
}

// Windows defaults to unpacked location
private File getChromeExecutableLocation() throws IOException {

    File chromeExe;

    if (SystemUtils.IS_OS_WINDOWS) {
        chromeExe = new File(System.getProperty("win.google.chrome.bin"));
    } else {
        // Use the standard locator option for all other operating systems
        GoogleChromeLocator locator = new GoogleChromeLocator();
        BrowserInstallation installation = locator.findBrowserLocationOrFail();
        chromeExe = new File(installation.launcherFilePath());
    }
    System.out.println("Chrome Exe: " + chromeExe.getAbsolutePath() + " Is File: " + chromeExe.isFile());
    if (! chromeExe.exists() || ! chromeExe.isFile()) {
        throw new IOException("Cannot locate Chrome Executable.  Expected Location: " + chromeExe.getAbsolutePath());
    }
    return chromeExe;
}