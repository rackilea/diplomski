private void init() throws IOException{
        char privateKeyChar[] = sshPrivateKey.toCharArray();

        conn = new Connection(ftpHostname,22);
        conn.connect();

        boolean isAuthenticated = conn.authenticateWithPublicKey(sshUsername, privateKeyChar, null);
        if (isAuthenticated == false)
            throw new IOException("Authentication failed.");

        session = conn.openSession();       
    }

    public String excuteCMD(String cmd) throws IOException
    {
        session = conn.openSession();
        session.execCommand(cmd);
        InputStream stdout = new StreamGobbler(session.getStdout());
        BufferedReader br = new BufferedReader(new InputStreamReader(stdout));

        while (true)
        {

            String line = br.readLine();
            if (line == null)
                break;
            else
                output+=line;
        }

        return output;
    }