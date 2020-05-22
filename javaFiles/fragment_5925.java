final StringBuilder ret = new StringBuilder();

final Runtime rt = Runtime.getRuntime();
final String[] commands = { "cmd", "/c", "cd c:\\myuser" };

final Process proc = rt.exec(commands);

final BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
final BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

String s = null;

while ((s = stdInput.readLine()) != null) {
    ret.append(s).append("\n");
}

while ((s = stdError.readLine()) != null) {
    ret.append(s).append("<br />");
}
String res = ret.toString();