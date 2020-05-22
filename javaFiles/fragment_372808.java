private void initButtonListeners() {
    this.averageDegreeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            computeAverageDegree();
        }
    }

    // other buttons...
}