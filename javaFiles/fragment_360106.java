final AlertDialog alert = builder.create();
alert.setOnShowListener(new DialogInterface.OnShowListener() {
    @Override
    public void onShow(DialogInterface dialog) {
        Button btnPositive = alert.getButton(Dialog.BUTTON_POSITIVE);
        btnPositive.setTextSize(TEXT_SIZE);

        Button btnNegative = alert.getButton(Dialog.BUTTON_NEGATIVE);
        btnNegative.setTextSize(TEXT_SIZE);
    }
});

return alert;