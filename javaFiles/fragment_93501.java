protected void printExceptionMessage(final TCException exception) {

    SwingUtilities.invokeLater(
        new Runnable() {
            public void run() {

                Date recordDate = exception.getTimeStamp();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
                String recordTime = sdf.format(recordDate);

                String message = "(" + recordTime + ") EXCEPTION:   " + exception.getMessage() + "\n";

                statusColorTextPane.setEditable(true);

                // trim the textPane to the buffer size
                Document doc = statusColorTextPane.getStyledDocument();
                int overLength = doc.getLength() + message.length() - Foo.TEXT_BUFFER_SIZE;

                if (overLength > 0) {
                    try {
                        doc.remove(0, overLength);
                    } catch (Exception ex) {

                        System.err.println("Error occured while trimming the textPane.");
                        ex.printStackTrace();
                    }
                }
                statusColorTextPane.append(Color.red, message);
                statusColorTextPane.setEditable(false);
            }
        });     
}