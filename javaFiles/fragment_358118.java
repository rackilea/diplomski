private void showImage() {
    final Dialog nagDialog = new Dialog(getActivity(),android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
    nagDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    nagDialog.setCancelable(false);
    nagDialog.setContentView(R.layout.test);
    Button btnClose = (Button)nagDialog.findViewById(R.id.btnIvClose);
    ImageView ivPreview = (ImageView)nagDialog.findViewById(R.id.iv_preview_image);

    // Loading image from url in ImageView ... HERE IS THE PROBLEM
    Picasso.with(getActivity()).load(mCurrentReportString.getUrlImages()).into(ivPreview);  

    btnClose.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {

            nagDialog.dismiss();
        }
    });
    nagDialog.show();
}