private void createWebPrintJob(WebView webView) {

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        PrintDocumentAdapter printAdapter =
                null;
        printAdapter = webView.createPrintDocumentAdapter("MyDocument");
        String jobName = getString(R.string.app_name) + " Print Test";

        printManager.print(jobName, printAdapter,
                new PrintAttributes.Builder().build());
    }
    else{
        Toast.makeText(MainActivity.this, "Print job has been canceled! ", Toast.LENGTH_SHORT).show();
    }

}