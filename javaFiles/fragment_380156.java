public void onActivityResult (int requestCode, int resultCode, Intent intent) {
    super.onActivityResult (requestCode, resultCode, intent);    

    //First initialize these variables and then use setVisbility function
    f2=(Button)findViewById(R.id.f2);
    f2.setEnabled(false);
    f2lock=(ImageView)findViewById(R.id.f2lock);

    switch (resultCode) {
        case 11: f2.setVisibility(View.VISIBLE);
                 f2lock.setVisibility(View.GONE);               
                        }    
    //Rest of your code
}