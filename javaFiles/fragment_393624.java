private void hideProgress() {
        if (pDialog != null) {
            if (pDialog.isShowing()) {
                pDialog.dismiss();
                pDialog = null;
            }
        }
    }