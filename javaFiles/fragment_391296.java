((ChannelExec(channel).setCommand(command);
    channel.setInputStream(null);
    ((ChannelExec(channel).setErrStream(System.err);
    InputStream input = channel.getInputStream();
    InputStream error = channel.getExtInputStream();
    channel.connect();
    List<String> output = new ArrayList<>();
    List<String> errorOutput = new ArrayList<>();

    try {
        InputStreamReader inputReader = new InputStreamReader(input);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        InputStreamReader errorReader = new InputStreamReader(error);
        BufferedReader errorBufferedReader = new BufferedReader(errorReader);
        String line = null;
        while (true) {
            while ((line = bufferedReader.readLine()) != null) {
                output.add(line);
                System.out.println("here is a line " + line);
            }
            while ((line = errorBufferedReader.readLine()) != null) {
                Output.add(line);
                System.out.println("here is an error line " + line);
            }
        if (channel.isClosed()( { etc etc }