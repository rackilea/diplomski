if (isNetworkAvailable()) {
                    //Network availabe...
                } else {
                    Toast alrtMsg = Toast.makeText(this, "No network connection available !!!", Toast.LENGTH_LONG);
                    alrtMsg.setGravity(Gravity.CENTER, 0, 0);
                    alrtMsg.show();
                }