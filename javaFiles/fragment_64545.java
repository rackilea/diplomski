protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ListView list = (ListView)findViewById(R.id.choose_sound_listView);

    new AsyncTask<Void, Void, List<String>>() {
        @Override
        protected List<String> doInBackground(Void... params) {
            try {
                return executeRemoteCommand(user, pass, host, portNum);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(List<String> soundNames){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1, android.R.id.text1, soundNames);
            list.setAdapter(adapter);
        }
    }.execute();
}

public List<String> executeRemoteCommand(String username, String password, String hostname, int port) throws Exception {

    List<String> soundNames = new ArrayList<String>();

    JSch jsch = new JSch();
    Session session = jsch.getSession(username, hostname, port);
    session.setPassword(password);

    // Avoid asking for key confirmation
    Properties prop = new Properties();
    prop.put("StrictHostKeyChecking", "no");
    session.setConfig(prop);

    session.connect();

    String command = "ls -la | awk '{ print $9}'";

    Channel channel = session.openChannel("exec");
    ((ChannelExec) channel).setCommand(command);

    ((ChannelExec) channel).setErrStream(System.err);

    InputStream in = channel.getInputStream();

    System.out.println("Connect to session...");
    channel.connect();

    StringBuffer buffer = new StringBuffer();

    //This is the recommended way to read the output
    byte[] tmp = new byte[1024];
    while (true) {
        while (in.available() > 0) {
            int i = in.read(tmp, 0, 1024);
            if (i < 0) {
                break;
            }
            buffer.append(new String(tmp, 0, i));
        }
        if (channel.isClosed()) {
            System.out.println("exit-status: " + channel.getExitStatus());
            break;
        }
        try {
            Thread.sleep(1000);
        } catch (Exception ee) {
        }
    }
    channel.disconnect();
    session.disconnect();

    Scanner scanner = new Scanner(buffer.toString());
    while (scanner.hasNextLine()){
        String line = scanner.nextLine();
        soundNames.add(line);

        Log.i("SSH", ": " + line);
    }

    return soundNames;
}