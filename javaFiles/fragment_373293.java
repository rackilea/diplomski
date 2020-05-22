public synchronized void putTime() {

    while (true) {  // To ensure list contains 5 elements at any point of time before removal
        if (messages.size() >= MAXMESSAGE) {
            try {
                wait(); // wait issued only when list is full
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (messages.size() < MAXMESSAGE) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            messages.add(dateFormat.format(cal.getTime()).toString());
        }

        notify();   // notify getTime() to resume execution
    }
}

public synchronized String getTime() {
    String message = "Unable to fetch time";

    try {
        Thread.sleep(100);  // adding delay to help see the output

        if (messages.isEmpty()) {
            wait(); // wait for putTime() to add messages to the list
        }

        if (!messages.isEmpty()) {
            message = messages.remove(messages.size() - 1);
            notify();   // notifies putTime() to add a message to the list; helps keep count to 5
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    return message;
}