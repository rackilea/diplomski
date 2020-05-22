new Thread(new Runnable() {
        @Override
        public void run() {
            while (progressStatus < 100) {
                // Progress update...
            }

            // Progress finished, re-enter UI thread and set text
            handler.post(new Runnable() {
                @Override
                public void run() {
                    EditText weightText = (EditText) findViewById(R.id.editText1);
                    EditText heightText = (EditText) findViewById(R.id.editText2);
                    TextView result = (TextView) findViewById(R.id.textView4);

                    float weight = Float.parseFloat(weightText.getText().toString());
                    float height = Float.parseFloat(heightText.getText().toString());

                    float bmi = calcBMI(weight, height);
                    float roundedbmi = (float) (Math.round(bmi*100.0)/100.0);

                    String yoFat = fat(roundedbmi);

                    result.setText("Your BMI is: " + roundedbmi + "\n" + yoFat);
                }
            });
        }
    }).start();