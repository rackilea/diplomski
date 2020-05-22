ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
                System.out.println("Hello!");

        }
    };
    javax.swing.Timer t = new javax.swing.Timer(Integer.parseInt(delayField.getText()) * 1000, taskPerformer);
    t.setRepeats(false);
    t.start();