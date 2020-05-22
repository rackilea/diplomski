String[] shCommand = {"/bin/sh", "-c", "mv somefile newfile"}; 

    // creates a process to run the command in
    Runtime rt = Runtime.getRuntime();
    Process prcs = null;
    try
    {
        // run the command
        prcs = rt.exec(shCommand);
    }
    catch (Exception e)
    {
        console.err("Execute Command Error:");
        e.printStackTrace();
    }