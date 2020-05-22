if (dollarfield.getText().toString().equals(""))
    {
            Toast.makeText(getApplicationContext(), "no value has been entered", Toast.LENGTH_LONG).show();

    }
    else
    {
Double dollarAmount = Double.parseDouble(dollarfield.getText().toString());

            Double poundAmount = dollarAmount * 0.7;

            Toast.makeText(getApplicationContext(), poundAmount.toString() + "Pounds", Toast.LENGTH_LONG).show();
    }