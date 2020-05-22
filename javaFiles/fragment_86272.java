} else {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setMessage("Login informations are wrong. Please check email and password")
            .setNegativeButton("Retry",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            //retry or dialog.dismiss();
            }
            })
            .create()
            .show();

        }
    } catch (JSONException e) {
        e.printStackTrace();
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Webspace is currently not reachable.")
        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int id) {
         dialog.dismiss();
        }
        })
        .create()
        .show();
     }