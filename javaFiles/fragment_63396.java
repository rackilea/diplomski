public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == CAM_REQUEST) {
            if (resultCode == RESULT_OK) {    
                Bundle extras =  data.getExtras()    
                Intent i = new Intent(this, PostActivity.class);
                i.putExtra("extras", extras);
                startActivity(i);
            }
     }
}