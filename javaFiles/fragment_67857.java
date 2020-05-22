public void write(String message) {
    try {
        logFile = new File("log.txt");
        writer = new BufferedWriter(new FileWriter(logFile));

        if (!logFile.exists()) {
            writer.write(message);
            writer.close();
        } else {
            read();
             if (logFile.isFile()) {
                 logFile.delete();

                 writer.write(message);
             }
        }
        //close the buffer writer in order to save
        writer.close();
    } catch (IOException e) {
        if (Main.outputTOCMD) {
            cmd.out(e.getMessage());
        } else {
            e.printStackTrace();
        }
    }
}