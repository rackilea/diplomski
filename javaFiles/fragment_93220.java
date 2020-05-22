/get entered texts from the edittexts,and convert to integers.
Integer value1 = Integer.parseInt(sand1.getText().toString());


//doing a calculation
Double calculatedValue1 = (9.5*value1);


//set the value to the textview, to display on screen.
result1.setText("$"+ String.format( "%.2f", calculatedValue1 ));