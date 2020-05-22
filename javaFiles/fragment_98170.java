try {

    String command = "perl C:\\Users\\Madhawa.se\\Desktop\\js\\mm.pl";
    Process process = Runtime.getRuntime().exec(command);
    process.waitFor();
    if (process.exitValue() == 0) {
        System.out.println("Command Successful");
    } else {
        System.out.println("Command Failure");
    }
} catch (Exception e) {
    System.out.println("Exception: " + e.toString());
}