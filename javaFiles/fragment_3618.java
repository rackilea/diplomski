private void  setSMSData(List<String> products,List<String> quantitys) {

        // add the phone number in the data
        Uri uri = Uri.parse("smsto:" + "09257777547");

        Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
        // add the message at the sms_body extra field
        List<String> format = new ArrayList<>();
        int i=-1;
        foreach(String str in products){
        i++;
          format.Add(str+":"+quantitys[i];
        }
        String formats= Arrays.toString(format);

        smsSIntent.putExtra("sms_body", "Order "+formats+" (Sent Via SKIP MOBILE)");
        try{
            startActivity(smsSIntent);
        } catch (Exception ex) {
            Toast.makeText(CartActivity.this, "Your sms has failed...",
            Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }

    }