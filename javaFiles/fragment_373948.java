public void resetButtonNumbers(){
    Random randd = new Random();
    value = randd.nextInt(100)+1;
    value2 = randd.nextInt(100)+1;

    btn1.setText("" + value);
    btn2.setText("" + value2);
}