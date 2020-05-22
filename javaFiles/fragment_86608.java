ProcessBuilder builder = new ProcessBuilder("./script.sh",
                            "parameter1");
            builder.directory(new File("/home/user/scripts/"));
            builder.inheritIO();

            try {
                    Process p = builder.start();
                    p.waitFor();
                    // Wait for to finish
            } catch (InterruptedException e) {
                    e.printStackTrace();
            } catch (IOException ioe) {
                    ioe.printStackTrace();
            }