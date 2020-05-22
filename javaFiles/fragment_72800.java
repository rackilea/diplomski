public synchronized void serialEvent(SerialPortEvent oEvent) {
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        try {
            int available = input.available();
            while (available > 0)
            {
                byte chunk[] = new byte[available];
                input.read(chunk, 0, available);

                System.out.println(new String(chunk));

                // Perform your packet processing here

                // See if there is any more data that came in while we were
                // processing the event
                available = input.available();
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    // Ignore all the other eventTypes, but you should consider the other ones.
}