class proceesImageTask extends AsyncTask<Void,Void,Void>
{
 ProgressDialog dialog;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                dialog = ProgressDialog.show(context, "","Please wait...", true);
                dialog.show();

            }
@Override
            protected Void doInBackground(String... str) {
//your process
}

@Override
            protected void onPostExecute(Void result) {
dialog.dismiss();   
}
}