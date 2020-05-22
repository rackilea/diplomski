...
.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int id) {
        dissmissDialog(DIALOG_NO_LICENSE_ID);
        CalculatorTabActivity.this.checkLicense();
    }
})