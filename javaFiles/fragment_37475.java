Double number = Double.valueOf(text);

DecimalFormat dec = new DecimalFormat("#.00 EUR");
String credits = dec.format(number);

TextView tt = (TextView) findViewById(R.id.creditsView);
tt.setText(credits);