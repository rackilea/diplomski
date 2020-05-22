static class CommandLine {
    HashMap<String,Options> options = new HashMap<String,Options>();

    public void register(String cmd, Options opts) {
        options.put(cmd, opts);
    }

    public void parse(String line) {
        // a better parser here would handle quoted strings
        String[] split = line.split("\\s");

        String cmd = split[0];
        String[] args = new String[split.length-1];
        if (args.length > 0)
            System.arraycopy(split, 1, args, 0, args.length);

        Options opts = options.get(cmd);
        if (opts == null) 
            ; // handle unknown command
        else {
            opts.parse(args);
            // handle results...
            opts.reset(); // required?
        }
    }
}

public static void main(String[] args) throws Exception {

    CommandLine cl = new CommandLine();
    cl.register("size", new Options());        // This will vary based on library Some
    cl.register("create-char", new Options()); // require subclasses, others use builder
    //...                                         pattern, or other means.

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
        cl.parse(in.readLine());
    }
}