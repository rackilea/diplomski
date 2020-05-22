Pattern saca_pid = Pattern.compile("\\(\\s*(\\d+)\\):");
StringBuilder log = new StringBuilder();
String line = "";
while (true) {
    try {
        if (!((line = bufferedReader.readLine()) != null)) break;
    } catch (IOException e) {
        e.printStackTrace();
    }
    Matcher encuentra_pid = saca_pid.matcher(line);
    if (encuentra_pid.find()) {
        String pid = encuentra_pid.group(1);
    }
}