Process proc = Runtime.getRuntime().exec(.....);  // TODO: Fix!

StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), GobblerType.ERROR);
StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), GobblerType.OUTPUT);

new Thread(errorGobbler).start();
new Thread(outputGobbler).start();

int exitVal = proc.waitFor();
proc.destroy();