private final String scriptPath = "/home/kemallin/Desktop/";

public void cleanCSVScript() {

    String script = "clean.sh";
    try {
        Process awk = new ProcessBuilder("/bin/bash", scriptPath + script).start();
        awk.waitFor();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}