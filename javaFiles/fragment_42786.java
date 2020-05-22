Process p = null;
    try {
        p = p = r.exec(cmd2);
        p.getOutputStream().close(); // close stdin of child

        InputStream processStdOutput = p.getInputStream();
        Reader r = new InputStreamReader(processStdOutput);
        BufferedReader br = new BufferedReader(r);
        String line;
        while ((line = br.readLine()) != null) {
             //System.out.println(line); // the output is here
        }

        p.waitFor();
    }
    catch (InterruptedException e) {
            ... 
    }
    catch (IOException e){
            ...
    }
    finally{
        if (p != null)
            p.destroy();
    }