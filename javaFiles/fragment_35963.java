@Override
onUpdate(int dataType, Data data){
   if (dataType == DATA_TAX_RATE){
      textViewTaxRate.setText(String.parseInt(data.getValue()));
   }

}