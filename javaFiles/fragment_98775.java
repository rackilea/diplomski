public static String[] runDiagnostics() throws IOException {

     gui gui1 = new gui();
     gui1.setCurStatus("Now running diagnostics... Please wait!");

     int i = 0;
     int errorsI = 0;
     File f = new File("tasks.txt");
     String[] errors = { "", "", "", "", "" };

     // try to create the file three times
     do {
        f.createNewFile();
        i++;
     } while (!f.exists() && i < 3);