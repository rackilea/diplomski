@Override
                public void onResponse(String response) {
                    Toast.makeText(registration.this,"Response :"+response,Toast.LENGTH_SHORT).show();
                    try {
                        JSONArray jsonArray=new JSONArray(response);
                        dialog.dismiss();
                        finish();
                    startActivity(new Intent(registration.this,MainActivity.class));                                                                                
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }