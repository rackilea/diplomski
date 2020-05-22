public void createGUI() {
        setLayout(new BorderLayout());
        JScrollPane jsp = new JScrollPane(txt = new JTextArea(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(jsp, BorderLayout.CENTER);
        add(ppButton = new JButton(RUNNING), BorderLayout.SOUTH);
        ppButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // This is where we acquire the lock to safely look at the state
                lock.lock();
                System.out.println(1);
                // Manipulate the state
                if (running) {
                    running = false;
                    ppButton.setText(SUSPENDED);
                } else {
                    running = true;
                    ppButton.setText(RUNNING);
                }

                // Signal that this conditional changed (is either true or false now)
                cond.signalAll();
                // Release the lock so other entities can go forward
                lock.unlock();

            }
        });
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                // This should block until this condition is true with a loop
                while (!running)
                    cond.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            txt.append("\n" + dateFormat.format(cal.getTime()));
            // No need to sleep()
            System.out.println(2);
            lock.unlock();
        }
    }

}