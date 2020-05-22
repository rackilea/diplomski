public boolean SaveData()
        {
        final TextView txtUserID = (TextView)findViewById(R.id.txtUserID);
        final TextView txtAppointmentID = (TextView)findViewById(R.id.txtAppointmentID);
        final EditText txtType = (EditText)findViewById(R.id.txtType);
        final EditText txtDate = (EditText)findViewById(R.id.txtDate);
        final EditText txtTime = (EditText)findViewById(R.id.txtTime);

        //Dialog
        final AlertDialog.Builder ad = new AlertDialog.Builder(this);

        ad.setTitle("Error! ");
        ad.setIcon(android.R.drawable.btn_star_big_on);
        ad.setPositiveButton("Close", null);

        String url = "http://10.0.2.2/appointments/updateData.php";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("sUserID", txtUserID.getText().toString()));
        params.add(new BasicNameValuePair("sAppointmentID", txtAppointmentID.getText().toString()));
        params.add(new BasicNameValuePair("sType", txtType.getText().toString()));
        params.add(new BasicNameValuePair("sDate", txtDate.getText().toString()));
        params.add(new BasicNameValuePair("sTime", txtTime.getText().toString()));

        String resultServer  = getHttpPost(url,params);
        Log.d(tag, "resultServer - updateData:: " + resultServer);

        /*** Default Value ***/
        String strStatusID = "0";
        String strMessage = "Unknow Status!";

        JSONObject c;
        try {
        c = new JSONObject(resultServer);
        strStatusID = c.getString("StatusID");
        strMessage = c.getString("Message");
        } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }

        // Prepare Save Data
        if(strStatusID.equals("0"))
        {
        ad.setMessage(strMessage);
        ad.show();
        return false;
        }
        else
        {
        Toast.makeText(UpdateActivity.this, "Update Data Successfully", Toast.LENGTH_SHORT).show();
        }        

        return true;
        }