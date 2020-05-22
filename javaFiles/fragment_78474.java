@Test
    public void run() throws IOException {
        String currentDir = new File(System.getProperty("user.home"),"desktop/notepad.lnk").getCanonicalPath();

        ProcessBuilder processBuild = new ProcessBuilder(currentDir);
        processBuild.command("cmd", "/c", "start","/wait", currentDir);
        Process p= processBuild.start();
        try {
            p.waitFor();
        } catch (InterruptedException ex) {

        }
        System.out.println("process terminated!");

    }