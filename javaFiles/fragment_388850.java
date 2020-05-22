public String sendMessage(String message) throws IOException {
    Runtime rt = Runtime.getRuntime();
    Process proc = rt.exec("python /Users/user/bot.py " + message);

    BufferedReader stdInput = new BufferedReader(new
            InputStreamReader(proc.getInputStream()));

    BufferedReader stdError = new BufferedReader(new
            InputStreamReader(proc.getErrorStream()));

    // read the output from the command
    String s = null;
    StringBuilder answer = new StringBuilder();
    while ((s = stdInput.readLine()) != null) {
        answer.append(s);
    }

    return answer.toString();
}