Timer printJobsTimer = new Timer(100, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            // Process a print job:

            if (channel != null) {
                Message template = new Message();
                template.Channel = channel;
                template.position = new Integer(getNumber() + 1);

                Message msg = (Message) space.read(template, null,
                        Long.MAX_VALUE);

                messageList.append(msg.execute());
            }
        }
    });
    printJobsTimer.setInitialDelay(100);
    printJobsTimer.start();