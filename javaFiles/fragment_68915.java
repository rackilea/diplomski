gene.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            int ringtoneVolumeValue = ring_bar.getProgress();
            String ringtoneVolume = Integer.toString(ringtoneVolumeValue);
            BitMatrix bitMatrix = multiFormatWriter.encode(ringtoneVolume, BarcodeFormat.QR_CODE,200,200);
            //....
        }
        catch (WriterException e){
            e.printStackTrace();
        }

    }
});