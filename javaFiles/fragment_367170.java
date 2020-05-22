Process p = Runtime.getRuntime().exec("cmd");
    new Thread(() -> {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }).start();
    try (PrintStream out = new PrintStream(p.getOutputStream())) {
        out.println("C:/TERRIERS/terrier/bin/trec_setup.bat");
        out.println("another.bat");
        // .....
    }
    p.waitFor();