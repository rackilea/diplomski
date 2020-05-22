File sdStorage;
if(sdStorage.isExternalStorageRemovable()) {
     sdStorage = Environment.getExternalStorageDirectory();
} else {
    Process process = null;
    Scanner scan = null;
    try {
        process = new ProcessBuilder().command("ls", "-l", sdStorage.getParent()).redirectErrorStream(true).start();
        scan = new Scanner(process.getInputStream());
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("\\s");
            if(parts.length > 2 && parts[2].equals("sdcard_rw") 
              && ! Environment.getExternalStorageDirectory().equals(Environment.getExternalStorageDirectory().getParent() + File.seperator + parts[3]) {
                sdStorage = new File(Environment.getExternalStorageDirectory().getParent() + File.seperator + parts[3]);
                break;
            }
        } catch(IOException e) {
            // Do something here
        } finally {
            if(scan != null)
                scan.close();
            if(process != null)
                process.destroy();
        }
    }
}