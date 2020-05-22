Runtime rt = Runtime.getRuntime();
    Process proc;
    int exitVal = -1;
    try {
        proc =  rt.exec("chmod 777 "+file);
        exitVal = proc.waitFor();
    } catch (Exception e) {}