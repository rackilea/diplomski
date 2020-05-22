if(Double.parseDouble(textfinal.getText().toString())>100){
          textfinal.setTextColor(Color.RED);
          disableButton();
          Log.i("yo","gray this out");
}else if(Double.parseDouble(textfinal.getText().toString())<100){
          textfinal.setTextColor(Color.BLACK);
          enableButton();
}