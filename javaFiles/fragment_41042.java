apply plugin: 'java'
apply plugin: 'application'

sourceCompatibility = '1.7'
targetCompatibility = '1.7'

// configuration-time of the original run task
run { 
    main = com.example.MainClass; // without this, our custom run will try to run "null"
}

task myRun(dependsOn: build) {

        // execution-time of our custom run task.
        doFirst {

            ProcessBuilder pb = new ProcessBuilder(tasks['run'].commandLine);
            pb.directory(tasks['run'].workingDir);

            // works when the gradle command is executed from IntelliJ IDEA, has no effect when executed from standalone CLI interface.
            pb.inheritIO(); 

            Process proc = pb.start();
            proc.waitFor();
        }
    }