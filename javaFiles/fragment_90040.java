...

// create a temp file and write your script to it
File tempScript = File.createTempFile("test_r_scripts_", "");
tempScript.setExecutable(true);
try(OutputStream output = new FileOutputStream(tempScript)) {
    output.write(script.getBytes());
}

// build the process object and start it
List<String> commandList = new ArrayList<>();
commandList.add(tempScript.getAbsolutePath());
ProcessBuilder builder = new ProcessBuilder(commandList);

...