List<String> commandLine = new ArrayList<>();

// (...)
commandLine.add("-ext");
commandLine.add("WixUtilExtension");
if (enableLicenseUI || enableInstalldirUI) {
    commandLine.add("-ext");
    commandLine.add("WixUIExtension.dll");
}

// (...)