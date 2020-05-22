public void resultsBreakdown(String result) {
    if (result.length() == 44) {
         pc.setText(result.CharSequence(2,10));
         pd.setText(result.CharSequence(13,18));
       sn.setText(result.CharSequence(21,27));
         nw.setText(result.CharSequence(13,18));
    } else {
        bcc.setText("invalid barcode");
    }
}