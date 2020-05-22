public void dec(View view) 
{
    try
    {
        EditText decimal = (EditText) findViewById(R.id.editDec);
        EditText hex = (EditText) findViewById(R.id.editHex);
        EditText bin = (EditText) findViewById(R.id.editBin);
        EditText oct = (EditText) findViewById(R.id.editOct);
        int deci = Integer.parseInt(decimal.getText().toString().trim());

        System.out.println ( "Original " + deci );
        System.out.println ( "Hexa : " + Integer.toHexString(deci) );
        System.out.println ( "Deci :" + Integer.toBinaryString(deci));
        System.out.println ( "Oct : " + Integer.toOctalString(deci) );

        hex.setText(String.valueOf(Integer.toHexString(deci)));
        bin.setText(String.valueOf(Integer.toBinaryString(deci)));
        oct.setText(String.valueOf(Integer.toOctalString(deci)));
    }
    catch ( Exception e )
    {
        System.out.println ( "Exception : " + e.toString() );
    }
}