b1.setOnClickListener(new OnClickListener() {

    @Override

    public void onClick(View v) {

        String f = et1.getText().toString();

        double i = Double.parseDouble(f);

        String s = et2.getText().toString();

        double j = Double.parseDouble(s);

        String w = et4.getText().toString();

        double q = Double.parseDouble(s);

        double price_gold = 10;


        double fpa = 10;

        double fpol = 10;

        double isot = 10;

        double sint_ker = 10;

        Integer result1 = ((int)i * price_gold) + ((int)j * 1000) + ((int)q * isot);

        result = result1 / 340;

        String res = String.valueOf(result);

        et3.setText(res);
    }