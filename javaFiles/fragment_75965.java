ProcessBuilder pb = new ProcessBuilder("java", "-javaagent:"+transagent.getAbsolutePath(), "YouMainClass");
    pb.redirectError(Redirect.appendTo(errorfile));
    pb.redirectOutput(Redirect.appendTo(logfile));

    try
    {
        pb.start();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }