void assign(String path, File jarFile) throws IOException {

    File cert = new File(path, "Cert");
    String password = "123";

    File script = new File(path, "assign.bat");
    String[] command = {
            script.getAbsolutePath(),
            password,
            cert.getAbsolutePath(),
            jarFile.getAbsolutePath()
    };

    Process proc = new ProcessBuilder(command).start();

}