// Check which radio button was clicked
switch(view.getId()) {
    case R.id.radioButtonSheet:
        if (checked)
            mImageNoteV.setImageResource(R.drawable.radio_button_note);
        defaultType= true;
        break;
    case R.id.radioButtonDone:
        if (checked)
            mImageNoteV.setImageResource(R.drawable.radio_button_check_box);
        noteCheck= true;
        break;
    case R.id.radioButtonPicture:
        if (checked)
            mImageNoteV.setImageResource(R.drawable.radio_button_photo);
        noteCheck = false;
        break;
}