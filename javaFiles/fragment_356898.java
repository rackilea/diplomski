...setPositiveButton("Photo",
    new DialogInterface.OnClickListener() { 
        public void onClick(...) {
            Intent data = new Intent();
            getTargetFragment().onActivityResult(getTargetRequestCode(), RESULT_PHOTO, data); 
        }})
.setNegativeButton(...
            getTargetFragment().onActivityResult(getTargetRequestCode(), RESULT_VID, data); ...