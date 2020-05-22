public void myLabelClicked(JLabel label, int i) {
    int r = i / COLS;
    int c = i % COLS;
    if (n == 0 && "vuota".equals(label.getName())) {
        n = 1;
        label.setText("ok1");
        label.setForeground(Color.GREEN);
        label.setName("piena");
        tbl[r][c] = 1;
    } else {
        n = 0;
        label.setText("ok2");
        label.setForeground(Color.GREEN);
        label.setName("piena");
        tbl[r][c] = 2;
    }
    System.out.println("tbl[" + r + "][" + c + "] = " + tbl[r][c]);
}