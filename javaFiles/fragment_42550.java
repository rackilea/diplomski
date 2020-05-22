if (TextUtils.isEmpty(str1)) {
            weightIn.setError("Please enter your weight");
            weightIn.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(str2)) {
            heightIn.setError("Please enter your height");
            heightIn.requestFocus();
            return;
        }else{
        float weight = Float.parseFloat(str1);
        float height = Float.parseFloat(str2) ;

        float bmiValue = calculateBMI(weight, height);

        String bmiInterpretation = interpretBMI(bmiValue);

        tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));
      }