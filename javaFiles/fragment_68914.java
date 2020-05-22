@Override
protected void onCreate(Bundle savedInstanceState) {
//....

int ring = ring_bar.getProgress();//Progress at the time of onCreate

gene.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
           //collect is still the same value since onCreate 
            BitMatrix bitMatrix = multiFormatWriter.encode(collect, BarcodeFormat.QR_CODE,200,200);
            //....
        }
        catch (WriterException e){
            e.printStackTrace();
        }

    }
});