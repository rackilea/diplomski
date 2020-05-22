//The suggested way lately
DecimalFormat formatter = new DecimalFormat("#0.00");        
twoDecimals.setText(formatter.format(2.123145));

//The usual way with some caveats
twoDecimals.setText(String.format("%.2f",2.123));