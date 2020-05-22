public void onOkButtonClick(final View view){

    try{

        Spinner mySpinner = (Spinner)findViewById(R.id.spinner);
        String Text = mySpinner.getSelectedItem().toString();

        Random random = new Random();
        int user_id = (random.nextInt(65536)-32768);
        String user_id2 = Integer.toString(user_id);

        StringBuilder str = new StringBuilder();

        str.append("New User \n");
        str.append("ID - " + user_id2 + "\n");
        str.append("Name - " + card_holder.getText().toString() + "\n");//appends the string to the file
        str.append("Brand - " + brand.getText().toString()  + "\n");//appends the string to the file
        str.append("CVV - " + cvv.getText().toString()  + "\n");
        str.append("Valid From - " + date_from.getText().toString()  + "\n");//appends the string to the file
        str.append("Valid Till - " + date_till.getText().toString()  + "\n");//appends the string to the file
        str.append("Account Number - " + encrypt_ac_num.getText().toString() + "\n");//appends the string to the file
        str.append("User PIN - "+ userPIN.getText().toString() + "\n");//appends the string to the file
        str.append("Email Address - " + userEmail.getText().toString()  + "\n");//appends the string to the file
        str.append("Date Of Birth - " + userDay.getText().toString() + "/" +
                                        userMonth.getText().toString() + "/" + 
                                        userYear.getText().toString()  + "\n");//appends the string to the file         
        str.append("Secrutiy Question - " + Text  + "\n");//appends the string to the file

        str.append("Secrutiy Answer - " + answer.getText().toString()  + "\n");//appends the string to the file
        str.append("-------------------------------------------------------------------------"  + "\n" );//appends the string to the file

        String s = str.toString();

        File file = generateNoteOnSD("UserDetails_" +user_id2+ ".txt", s);

        ServerIO server = new ServerIO();
        String[] arg = new String [2];
        arg[0] = "username@cube.netsoc.tcd.ie:UserDetails_" + user_id2+".txt";
        arg[1] = "UserDetails_" +user_id2+ ".txt";

        String transfer = server.sendFile(arg, "UserDetails_" +user_id2+ ".txt");
        file.delete();
        //server.getFile(arg, "UserDetails.txt");
        //Toast.makeText(this, transfer, 10000).show();

    }catch(Exception e)
    {
            Log.e("Exception", "File write failed: " + e.toString());
    }
    Intent startMain = new Intent(this, menu.class);
    startActivity(startMain);
}