for (int i=0 ; i<inviteArray.length; ++i){
    try {
        inviteTextView[i].setText("" + inviteArray[i]);
    } catch (Exception e) {
        e.printStackTrace();
    }
}