class MapServerThread implements Runnable {

    private enum Commands {
        PUT("(put)\\s(\\S+)\\s(\\d)"),
        //add all your commands here and give an approriate regular expression
        UNKNOWN(".+");

        private final String pattern;

        Commands(String regexPattern) {
            pattern = regexPattern;
        }

        private static Commands parseCommand(String s) {
            Commands result = UNKNOWN;

            s = s.toLowerCase(Locale.getDefault());

            for (Commands command : values()) {
                if (command != UNKNOWN && command.pattern.matches(s)) {
                    result = command;
                    break;
                }
            }
            return result;
        }
    }

    private Map<String, Integer> map = new HashMap<>();
    private Socket sock;

    public MapServerThread(Socket s) {
        sock = s;

        List<String> strs = Arrays.asList("aaa a", "b", "a");
        for (String str : strs) {
            map.put(str, str.length());
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            PrintWriter writer = new PrintWriter(sock.getOutputStream(), true);

            writer.println("Welcome to the map service.");

            String inputLine = null;
            while ((inputLine = reader.readLine().trim()) != null) {
                Commands command = Commands.parseCommand(inputLine);

                writer.println(command.name());

                execute(command, inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void execute(Commands command, String inputLine) {

        switch (command) {
            case PUT:
                String[] args = inputLine.split(" ");
                map.put(args[1], Integer.parseInt(args[2]));
                break;
            //handle the other commands accordingly
            default:
                // notify about an error
                break;

        //
        // get [string] - this should return the int associated with this string
        //
        // keyset - return all keys
        //
        // values - return all values
        //
        // mappings - return all mappings
        //
        // bye - quit the client
        //
        // help - doesn't do anything yet, but will list all commands and their
        // syntax

        }
    }

}