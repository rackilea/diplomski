public void CustomDialogLoadImage() {
    Dialog dialog = new Dialog(this);
    dialog.setContentView(R.layout.custom_dialogbox_image);
    ImageView FF_ReceiptImage = (ImageView) dialog.findViewById(R.id.FF_ReceiptImage);
    Picasso.with(ConveyanceAmtUpdateApprove.this).load("http://i.imgur.com/DvpvklR.png").into(FF_ReceiptImage);

    dialog.show(); 
}