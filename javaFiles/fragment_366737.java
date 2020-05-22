public void calculate2() {
    //get entered texts from the edittexts,and convert to integers.
    Double value1 = moneyToDouble(sand1.getText().toString());
    Double value2 = moneyToDouble(sand2.getText().toString());
    Double value3 = moneyToDouble(sand3.getText().toString());
    Double value4 = moneyToDouble(sand4.getText().toString());
    Double value5 = moneyToDouble(sand5.getText().toString());
    Double value6 = moneyToDouble(sand6.getText().toString());
    Double value7 = moneyToDouble(sand7.getText().toString());

    Double value8 = moneyToDouble(extra1.getText().toString());
    Double value9 = moneyToDouble(extra2.getText().toString());
    Double value10 = moneyToDouble(extra3.getText().toString());
    Double value11 = moneyToDouble(extra4.getText().toString());
    Double value12 = moneyToDouble(extra5.getText().toString());
    Double value13 = moneyToDouble(extra6.getText().toString());

    Double valuesubtotal = moneyToDouble(subtotal.getText().toString());
    Double valuetotal = moneyToDouble(total.getText().toString());
    //do the calculation

    Double calculatedValue1 = (9.5*value1);
    Double calculatedValue2 = (9.5*value2);
    Double calculatedValue3 = (9.5*value3);
    Double calculatedValue4 = (9.5*value4);
    Double calculatedValue5 = (9.5*value5);
    Double calculatedValue6 = (9.5*value6);
    Double calculatedValue7 = (9.5*value7);

    Double calculatedValue8 = (2.25*value8);
    Double calculatedValue9=(1.5*value9) ;
    Double calculatedValue10=(3.5*value10) ;
    Double calculatedValue11 =(3.95*value11) ;
    Double calculatedValue12 = (3.5*value12);
    Double calculatedValue13 = (2.95*value13);

    Double calculatedsubtotal = (d+calculatedValue1+calculatedValue2+calculatedValue3+calculatedValue4+calculatedValue5+calculatedValue6+calculatedValue7+calculatedValue8+calculatedValue9+calculatedValue10+calculatedValue11+calculatedValue12+calculatedValue13);
    Double calculatedtotal = ((.1*calculatedsubtotal)+calculatedsubtotal);

    //set the value to the textview, to display on screen.
    result1.setText("$"+String.format( "%.2f", calculatedValue1 ));
    result2.setText("$"+ String.format( "%.2f", calculatedValue2 ));
    result3.setText("$"+ String.format( "%.2f", calculatedValue3 ));
    result4.setText("$"+ String.format( "%.2f", calculatedValue4 ));
    result5.setText("$"+ String.format( "%.2f", calculatedValue5 ));
    result6.setText("$"+ String.format( "%.2f", calculatedValue6 ));
    result7.setText("$"+ String.format( "%.2f", calculatedValue7 ));

    extraresult1.setText("$"+ String.format( "%.2f", calculatedValue8 ));
    extraresult2.setText("$"+ String.format( "%.2f", calculatedValue9 ));
    extraresult3.setText("$"+ String.format( "%.2f", calculatedValue10 ));
    extraresult4.setText("$"+ String.format( "%.2f", calculatedValue11));
    extraresult5.setText("$"+ String.format( "%.2f", calculatedValue12));
    extraresult6.setText("$"+ String.format( "%.2f", calculatedValue13));

    subtotal.setText("$"+ String.format( "%.2f", calculatedsubtotal ));
    total.setText("$"+ String.format( "%.2f", calculatedtotal ));
}

private Double moneyToDouble(String total){

    String strAmount = total.replace("$","");
    double value = Double.valueOf(strAmount);

    return value;
}