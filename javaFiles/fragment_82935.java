Timer t = new Timer(200, new ActionListener() {
    int k = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (k++ < 19) {
            final double[] x = new double[1000];
            final double[] y = new double[1000];
            for (int i = 0; i < y.length; i++) {
                x[i] = i;
                y[i] = i * i * k;
            }
            plot2d(k % 12, x, y, "plot#" + k);
        }
    }
});
t.start();