public static String GetUninstallerPath() {
        try {
            //if (logger.IsInfoEnabled) logger.Info("GetUninstallerPath - begin");

            String uninstallerPath = null;

            try {
                String vncDisplayName = "UltraVNC";
                String subkey32 = "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall";
                String subkey64 = "Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall";

                boolean is64Bit = Platform.is64Bit();
                String[] key;
                if (is64Bit) {
                    key = Advapi32Util.registryGetKeys(WinReg.HKEY_LOCAL_MACHINE,
                            subkey64);
                } else {
                    key = Advapi32Util.registryGetKeys(WinReg.HKEY_LOCAL_MACHINE,
                            subkey32);
                }

                if (key != null) {
                    for (String nextSubkeyName : key) {

                        TreeMap<String, Object> subKey = Advapi32Util.registryGetValues(
                                WinReg.HKEY_LOCAL_MACHINE,
                                subkey64 + "\\" + nextSubkeyName);
                        Object value = subKey.get("DisplayName");
                        Object path = null;
                        if (value != null) {
                            if (value.toString().startsWith(vncDisplayName)) {
                                path = subKey.get("UninstallString");
                                if (path != null) {
                                    uninstallerPath = path.toString().trim();
                                }
                            }
                        }

                    }

                }

            }
            catch (Exception ex) {
                System.err.println(ex.getMessage());

            }

            return uninstallerPath;
         }
    }