private void setSMSData(String productName,String quantity) {


        // add the phone number in the data
        Uri uri = Uri.parse("smsto:" + "09257777547");

        Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
        // add the message at the sms_body extra field
        smsSIntent.putExtra("sms_body", "Order "+ productName+":"+quantity+" (Sent Via 
SKIP MOBILE)");
        try{
            startActivity(smsSIntent);
        } catch (Exception ex) {
            Toast.makeText(CartActivity.this, "Your sms has 
 failed...",
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }




    }
});