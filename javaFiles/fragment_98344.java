Instant start;

        @Override
        public void actionPerformed(ActionEvent e) {
            start = Instant.now();

            Timer timer = new Timer(1, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    time.setText(Duration.between(start, Instant.now()).getSeconds() + "");
                }
            });
            timer.start();
        }
    });