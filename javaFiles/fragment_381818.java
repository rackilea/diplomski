@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 0) {
        if (requestCode == CommonStatusCodes.SUCCESS) {
            if (data != null) {
                Barcode barcode = data.getParcelableExtra("barcode");
                barcodeResult.setText("Barcode value : " +                  barcode.displayValue);

                //-- THIS LINE WAS ADDED TO CALL METHOD
                resultsBreakdown(barcode.displayValue.toString());
           } else {
               barcodeResult.setText("No Barcode Found");
           }
           super.onActivityResult(requestCode, resultCode, data);
        }
   }
}