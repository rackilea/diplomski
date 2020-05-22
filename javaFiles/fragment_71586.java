public void Upload() {

        String file= FilePath.getPath(this, filePath);
        final String name = name_edt.getText().toString();
        final String email = email_edt.getText().toString();
        final String address = address_edt.getText().toString();


        final ProgressDialog pd;
        pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("Logging in...");
        pd.setCancelable(false);
        pd.show();
        final String url_ = "xxxxxxxxxxxxxxx";

        final File file = new File(Uri.parse(path).toString());



        Ion.with(MainActivity.this)
                .load("POST",url_)
                .progressDialog(pd)
                .setMultipartFile("file", file)
                .setMultipartParameter("Name", name)
                .setMultipartParameter("Email", email)
                .setMultipartParameter("Address.", address)

                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {


                        //     Toast.makeText(getApplicationContext(),""+file,Toast.LENGTH_LONG).show();

                        System.out.println("Error " + e);
                       // Toast.makeText(getApplicationContext(), "Exception : " + e, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                        // Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_LONG).show();


                        pd.dismiss();


                    }
                });
    }