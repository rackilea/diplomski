Double number = Double.valueOf(text);

DecimalFormat dec = new DecimalFormat("#.## EUR");
dec.setMinimumFractionDigits(2);
String credits = dec.format(number);

TextView tt = (TextView) findViewById(R.id.creditsView);
tt.setText(credits);