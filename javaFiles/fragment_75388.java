try {
        Thread.sleep(3000); // wait for response return
        String path = SERVER_RESTART_SCRIPT;
        Runtime rn = Runtime.getRuntime();
        Process proc = rn.exec(path);
        proc.waitFor();
        System.exit(0);
    } catch (IOException e) {
        logger.error("IO exception: " + e);
    } catch (InterruptedException e) {
        logger.error("InterruptedException: " + e);
    }

}