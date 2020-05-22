public static void main(String[] commandlineArgument) {
    if(commandlineArgument.length < 1) {
        System.err.println("Your error message"); // use the std error stream
        System.exit(-1);
    }
    ...