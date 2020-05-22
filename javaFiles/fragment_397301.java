String command = "cmd /c start cmd.exe ...your other commands";
try {
    Process process = Runtime.getRuntime().exec(command);
} catch (IOException e) {
    e.printStackTrace();
}