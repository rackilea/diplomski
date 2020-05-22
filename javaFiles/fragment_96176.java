String[] command = new String[]{mySQLDir+"\\bin\\mysql ", "-uroot", "--password=", "testdb"};
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder = new ProcessBuilder(Arrays.asList(command));
        processBuilder.redirectError(Redirect.INHERIT);
        processBuilder.redirectInput(Redirect.from(backupFile));
        Process process = processBuilder.start();
        process.waitFor();