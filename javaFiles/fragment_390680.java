public void run() {
                try {
                    sleep(timeToRun);
                    thisThread.interrupt();
                    b = serializer.serialize(map1);
                    map1 = new TreeMap<Long, Message>();  // Changed this line
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }