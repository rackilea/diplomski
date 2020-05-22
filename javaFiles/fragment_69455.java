public void addImg(){
    try{
        Runtime r = Runtime.getRuntime();

        //Don't use this one...
        //Process p = r.exec("/usr/bin/python2.7 ../wc.py");
        //p.waitFor();
        //p.destroy();

        //Use absolute paths (e.g blahblah/foo/bar/wc.py)
        p = r.exec("python2.7 ../wc.py");

        //Set up two threads to read on the output of the external process.
        Thread stdout = new Thread(new StreamReader(p.getInputStream()));
        Thread stderr = new Thread(new StreamReader(p.getErrorStream()));

        stdout.start();
        stderr.start();

        int exitval = p.waitFor();
        p.destroy();

        //Prints exit code to screen.
        System.out.println("Process ended with exit code:" + exitval);
    }catch(Exception e){
        String cause = e.getMessage();
        System.out.print(cause);
    }
}

private class StreamReader implements Runnable{
    private InputStream stream;
    private boolean run;

    public StreamReader(Inputstream i){
        stream = i;
        run = true;
    }

    public void run(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new InputStreamReader(stream));

            String line;

            while(run && line != null){
                System.out.println(line);
            }
        }catch(IOException ex){
            //Handle if you want...
        }finally{
            try{
                reader.close();
            }catch(Exception e){}
        }
    }
}