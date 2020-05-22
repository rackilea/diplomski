Process p;
        try {
            p = Runtime.getRuntime().exec("chmod 777 -R ./leaf1");
            p.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }