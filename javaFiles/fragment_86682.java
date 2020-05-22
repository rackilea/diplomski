String[] files = {
    "cheatsmasher.exe",
    "Everything.ini",
    "jdgui.jar",
    "launcher.jar - Shortcut.lnk",
    "LAV.cfg",
    "LAV.exe",
    "logs - Shortcut.lnk",
    "pexplorer32.exe",
    "pexplorer64.exe",
    "Prefech.lnk",
    "schem.exe",
    "SE32.exe",
    "SE64.exe",
    "skypefiles.lnk",
    "smash.dll",
    "synpase.lnk",
    "TM.lnk",
    "TS3Client.lnk",
    "USB32.cfg",
    "USB32.exe",
    "USB64.cfg",
    "USB64.exe",
    "Vape.dll",
    "vapev.jar",
    "versions - Shortcut.lnk",
};

Path destination = Paths.get("C:\\Dank");
Files.createDirectories(destination);

for (String file : files) {
    try (InputStream stream =
        SSTool.class.getResourceAsStream("/tools/" + file)) {

        Files.copy(stream, destination.resolve(file));
    }
}