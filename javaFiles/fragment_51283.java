Timer tim = new Timer (5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           presentTime++;
           if (presentTime == 24) {
             presentTime = 0;
             presentDay++;
           }
           //times how now been set
           //update your GUI here

        }
}