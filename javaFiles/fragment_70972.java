ProcessBuilder pb = new ProcessBuilder("mogrify", "-format ", "jpg ", psdafterconvpath, psdpath + "\\" + "*.psd");
    pb.redirectErrorStream(true);
    try {
        Process p = pb.start();
    } catch (IOException ex) {
        Logger.getLogger(DefineTask.class.getName()).log(Level.SEVERE, null, ex);
    }
    }