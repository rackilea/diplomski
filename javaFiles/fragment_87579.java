//Your above business logic for selecting file

Ion.with(SecondActivity.this)
                    .load(myURL)
                    .uploadProgressDialog(pd)
                    .setMultipartFile("SP-LOG", "image/*", file)
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {
                            Toast.makeText(SecondActivity.this,result, Toast.LENGTH_LONG).show();\
                            pd.cancel();


                        }
                    });