private void calculateMen(){

    //Your Code Goes here...

     String age, in, ft, weight;
     Double answer;
     age =  etage.getText().toString();
     in =  etin.getText().toString();    
     ft = etft.getText().toString();
     weight = etweight.getText().toString();

     answer=getAnswer(age,in,ft,weight,getSelectedItemValueFromSpinnerText(spinnerText));

     BigDecimal bd = BigDecimal.valueOf(answer);
     bd = bd.setScale(2, BigDecimal.ROUND_FLOOR);

     etanswer.setText(bd.toString()); 

     // call for custom toast
     viewBMRSavedToast();
    }

private Double getAnswer(String age, String in, String ft, String weight,
        Double selectedItemValueFromSpinner) {
    double answer = ( ( 66 + ( 6.2377 * Double.parseDouble( weight ) ) + 
             ( 12.7084 * ( Double.parseDouble( in ) * 12 + Double.parseDouble( ft ) ) )
             - ( 6.8 * Double.parseDouble( age ) ) ) * selectedItemValueFromSpinner ); 
    return answer;
}

private Double getSelectedItemValueFromSpinnerText(String spinnerText) {
    return spinnerValues.get(spinnerText);
}