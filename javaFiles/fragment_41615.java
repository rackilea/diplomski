ActionListener buttonListener = new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {

        javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //create the arrays
                chart1.setChart(chartTemp.runSimGraph("Title", "XLabel", "YLabel",true, new double[][]{Array1,Array2,Array3}));
            }

        });
        timer.start();
    }
};
myButton.addActionListener(buttonListener);