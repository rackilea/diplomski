File executor = File.createTempFile("Executor", ".sh");
        PrintWriter writer = new PrintWriter(executor, "UTF-8");

        writer.println("#!/bin/bash");
        writer.println();
        writer.println("java $* > /tmp/output.txt 2>&1 &");
        writer.close();
        executor.setExecutable(true); 

        File elevator = File.createTempFile("Elevator", ".sh");
        writer = new PrintWriter(elevator, "UTF-8");
        writer.println("#!/bin/bash");
        writer.println();
        writer.println(String.format("osascript -e \"do shell script \\\"%s $*\\\" with administrator privileges\"",
                executor.getPath()));
        writer.close();
        elevator.setExecutable(true);

        Runtime.getRuntime().exec(String.format("%s -cp %s Main param", 
                elevator.getPath(),
                Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));