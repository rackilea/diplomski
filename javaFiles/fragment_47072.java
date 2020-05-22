@Command(name = "git", subcommands = {Commit.class, Status.class})
class Git implements Runnable {
    public static void main(String[] args) { // top-level command needs main
        CommandLine.run(new Git(), args);
    }
    public void run() { System.out.println("Specify a subcommand"); }
}

@Command(name = "commit")
class Commit implements Runnable {
    @Option(names = "-m") String message;
    @Parameters File[] files;

    public void run() {
        System.out.printf("Committing %s with message '%s'%n",
                Arrays.toString(files), message);
    }
}

@Command(name = "status")
class Status implements Runnable {
    public void run() { System.out.println("All ok."); }
}