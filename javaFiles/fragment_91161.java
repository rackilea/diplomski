class Whatever extends Thread {
    public void run() {
        while (!interrupted()) {
            String str = listitem();
            if (str == null) // there are no more commands to run
                break;
            Runtime.getRuntime.exec(("cmd /C start abc.bat"+str).split("\\s")).waitFor();
}