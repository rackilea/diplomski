case R.id.btnCalcCalories:
    double weight = Integer.parseInt(weightEdittextValue.getText().toString());
    double bodyfat = Integer.parseInt(bodyfatEdittextValue.getText().toString());
    double lbm = weight*(100 - bodyfat)/100;
    lbmResult.setText(String.valueOf(lbm));
    break;