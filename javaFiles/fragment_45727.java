Process restoreProcess=null;
        try {
        String restoreCommand= "mysql ", "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source " + source"
        Runtime runtime = Runtime.getRuntime();
            restoreProcess = runtime.exec(restoreCommand);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Restored successfully!");
            } else {
                System.out.println("Could not restore the backup!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }