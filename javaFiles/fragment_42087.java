ProcessBuilder processBuilder =
  new ProcessBuilder(new String[] {
    "su", "-s", "/bin/sh", "myuser", "-c",
    "shopt -u huponexit; java -jar myjar.jar"
  });
Process p = processBuilder.start();