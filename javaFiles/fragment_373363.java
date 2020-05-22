BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = null;
    long maxWait = 5000; // 5 seconds
    long endTime = System.currentTimeMillis() + maxWait;
    boolean timeout = false;
    while (!reader.ready()) {
        synchronized(reader) {
            reader.wait(250);
        }
        if (System.currentTimeMillis() >= endTime) {
            timeout = true;
            break;
        }
    }
    if (!timeout) {
        input = reader.readLine();
    } else {
        System.out.println("timeout without input");
    }