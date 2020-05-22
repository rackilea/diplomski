@Override
      protected void onPreExecute() {
          progressDialog = new ProgressDialog(mContext);
          progressDialog.setMessage("Saving...");
          progressDialog.setCancelable(false);
          progressDialog.show();
          Log.e( "sending dvr to sqlite","yes"); 

      }