public static void closeQT(){
        //Pause the recording, save and quit
        try {
            String[] go = {"osascript", "-e", "set tFile to \""+fullPosixPathOfFile+"\" as posix file", "-e", "do shell script \"touch \" & quoted form of posix path of tFile", "-e", "tell application \"QuickTime Player\"", "-e", "pause document 1", "-e", "save document 1 in tFile", "-e", "stop document 1", "-e", "close document 1 saving no", "-e", "quit", "-e", "end tell"};
            Process process = Runtime.getRuntime().exec(go);
            process.waitFor();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }