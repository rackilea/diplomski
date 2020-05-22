public void pagestorebutton (){
        PDFView pdfView = findViewById(R.id.pdfView);
        savedpage = pdfView.getCurrentPage();
        Toast myToast = Toast.makeText(this,(String.valueOf(savedpage) ), Toast.LENGTH_SHORT);
        myToast.show();
        storepreferences();
    }