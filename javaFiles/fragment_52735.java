File bitbucket;

if (isWindows()) {
    bitbucket = new File("NUL");
} else {
    bitbucket = new File("/dev/null");
}

Process process = new ProcessBuilder("/bin/bash", "-c", "./start_server")
                  .redirectOutput(ProcessBuilder.Redirect.appendTo(bitbucket))
                  .redirectError(ProcessBuilder.Redirect.appendTo(bitbucket))
                  .start();