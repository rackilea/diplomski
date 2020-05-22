//Your above business logic for selecting file
Ion.with(SecondActivity.this)
                    .load(myURL)
                    .uploadProgressDialog(pd)
                    .setMultipartFile("SP-LOG", "image/*", file)
                    .asJsonObject()
                    .setCallback(new FutureCallback<JsonObject>() {
                        @Override
                        public void onCompleted(Exception e, JsonObject result) {
                            String message = result.getString("message");
                            Toast.makeText(SecondActivity.this,message, Toast.LENGTH_LONG).show();\
                            pd.cancel();


                        }
                    });