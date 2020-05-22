@Override
              public void onSuccess(JSONObject jsonObject) {
                    String token = "";

                    if (jsonObject.has("token")) {
                    /*Toast.makeText(_mainContext, "Login Success!", Toast.LENGTH_LONG).show();*/
                    token = jsonObject.optString("token");
                    Intent i = new Intent(context,LoggedActivity.class);
                    context.startActivity(i);
                     }
              }