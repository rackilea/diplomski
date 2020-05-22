String OS = System.getProperty("os.name").toLowerCase();

        if (isWindows(OS)) {
            String path = "c:\\";
            Runtime.getRuntime().exec(new String[] { "cmd.exe", "/C", "\"start; cd "+path+"\"" });;
        } else if (isMac(OS)) {
            //Open Mac Prompt
        } else if (isUnix(OS)) {
            //Open UnixPrompt
        } else if (isSolaris(OS)) {
            //Open Solaris Prompt
        } else {
            System.out.println("Your OS is not support!!");
        }

public static boolean isWindows(String OS) {

        return (OS.indexOf("win") >= 0);

    }

    public static boolean isMac(String OS) {

        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix(String OS) {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

    }

    public static boolean isSolaris(String OS) {

        return (OS.indexOf("sunos") >= 0);

    }