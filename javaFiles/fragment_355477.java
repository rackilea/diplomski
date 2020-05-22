Double firstNo, SecondNo, ThirdNo;
firstNo = Double.parseDouble(getIntent().getExtras().getString("firstno"));
SecondNo = Double.parseDouble(getIntent().getExtras().getString("secondno"));
ThirdNo = Double.parseDouble(getIntent().getExtras().getString("thirdno"));

textView.setText(String.valueOf(firstNo + SecondNo + ThirdNo));