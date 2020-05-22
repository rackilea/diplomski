x = -0.123f;
  text = (TextView)findViewById(R.id.acc_x);
  text.setText(String.format("%.3f",x));

  y = 0.123f;
  text = (TextView)findViewById(R.id.acc_y);
  text.setText(String.format("%.3f",y));

  z = 99.123f;
  text = (TextView)findViewById(R.id.acc_z);
  text.setText(String.format("%.3f",z));

  T = 0;
  text = (TextView)findViewById(R.id.acc_T);
  text.setText(String.format("%.3f",T));