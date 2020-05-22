public void ReadConnectionProperties(URL url, TextField dbhost1, TextField dbport1, TextField dbusername1, TextField dbpasswd1,TextField dbname1) throws IOException {
    String host, port, uname, password, name;
    /** */
    try ( final InputStream stream = url.openStream();
          final Reader reader = new InputStreamReader(stream);
          final BufferedReader br = new BufferedReader(reader); )
        {
        host = br.readLine();
        port = br.readLine();
        uname = br.readLine();
        password = br.readLine();
        name = br.readLine();

        dbhost1.setText(host);
        dbport1.setText(port);
        dbusername1.setText(uname);
        dbpasswd1.setText(password);
        dbname1.setText(name);
        }