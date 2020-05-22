String[] cmd = {
"/bin/sh", "-c", "cat /etc/*-release" };

try {
    Process p = Runtime.getRuntime().exec(cmd);
    BufferedReader bri = new BufferedReader(new InputStreamReader(
            p.getInputStream()));

    String line = "";
    while ((line = bri.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {

    e.printStackTrace();
}