String[] executeCmd = new String[] {
        "C:\\xampp\\mysql\\bin\\mysqldump.exe ",
        "-u ",
        dbUserName,
        "-p ",
        dbPassword,
        "--add-drop-database ",
        "-B ",
        dbName,
        "-r ",
        path
};

final ProcessBuilder pb = new ProcessBuilder(Arrays.asList(executeCmd));
final Process p;
try {
    p = pb.start();
    int processComplete = p.waitFor();

    if (processComplete == 0) {
        System.out.println("Backup created successfully");
        return true;
    } else {
        System.out.println("Could not create the backup");
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String line = null;
        while ( (line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
} catch (IOException | InterruptedException e) {
    e.printStackTrace();
}