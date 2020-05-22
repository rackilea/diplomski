public static boolean latestVersion() throws Exception {
    URL url = new URL("http://whereisthemonkey.weebly.com/better-mob-ai.html");
    InputStream inputStream = url.openStream();

    Scanner scanner = new Scanner(inputStream, "UTF-8");
    int numLine = 0;
    while (scanner.hasNext()) {
        String line = scanner.nextLine();
        numLine++;
        String status = "-1"; // equal any number like -1 which Status will never equal it
        if (line.contains("Status")) {
            int indexOfStatus = line.indexOf("Status");
            status = line.substring(indexOfStatus + 7, indexOfStatus + 9);
            System.out.println("line " + numLine + ": contains Status word | Status = " + status);
        }

        // use trim to avoid any spaces
        int latestVersion = Integer.parseInt(status.trim());
        if (latestVersion == 0) {
            scanner.close();
            inputStream.close();
            System.err.println("/=============================================================================\\");
            System.err.println("|[Better MobAI] The developing team of Better MobAI encountered a major error:|");
            System.err.println("|[Better MobAI] The plugin will be therefore disabled! |");
            System.err.println("\\============================================================================/");
            return false;
        }
        if (latestVersion == 1) {
            System.out.println("latestVersion: " + latestVersion);
            scanner.close();
            inputStream.close();
            return true;
        }
    }
    scanner.close();
    inputStream.close();
    return false;
}