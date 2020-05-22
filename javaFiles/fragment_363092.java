case R.id.btnCalcCalories:
            int weight = Integer.parseInt(weightEdittextValue.getText().toString());
            int bodyfat = Integer.parseInt(bodyfatEdittextValue.getText().toString());
            int lbm = weight*(100 - bodyfat)/100;
            lbmResult.setText(String.valueOf(lbm));
            break;