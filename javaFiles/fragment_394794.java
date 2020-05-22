@Override
        protected Response<String> parseNetworkResponse(NetworkResponse response) {

            if(response.statusCode==400){
                new SweetAlertDialog(getApplicationContext(), SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Errore comunicazione server")
                        .setContentText("Qualcosa non ha funzionato!\nCodice errore:"+response.statusCode)
                        .show();
                finish();
            }
            return super.parseNetworkResponse(response);
        }