final ProgressDialog progress = new ProgressDialog(this);

progress.setIndeterminate(false);
progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

progress.setOnShowListener(new OnShowListener() {   

    public void onShow(DialogInterface dialog) {
        progress.setProgress(50);
        progress.setSecondaryProgress(75);
    }
});

progress.show();