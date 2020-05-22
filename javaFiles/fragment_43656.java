// The value returned by context.getInstallationDirectory() will be
// the last installation directory if the user has already installed the application
ApplicationRegistry.ApplicationInfo applicationInfo =
    ApplicationRegistry.getApplicationInfoByDir(context.getInstallationDirectory());

if (applicationInfo == null) {
  // The application has never been installed before
    return true;
}

// The version of this installer is contained in a system installer variable
String myVersion = (String)context.getVariable("sys.version");
if (applicationInfo.getVersion().equals(myVersion)) {
    // In that case the current version is already installed.
    Util.showErrorMessage("The current version is already installed in this directory");
    // By returning "false", the action will fail and the installer will quit.
    // Note that you have to set the "Failure strategy" property of your 
    // "Run script" action to "Quit on error", otherwise the installer will continue.
    return false;
} else {
    return true;
}