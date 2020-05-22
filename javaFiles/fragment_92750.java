protected void onActivityResult(int requestCode, int resultCode, Intent data)
        {
            // TODO Auto-generated method stub
            if(requestCode==EMAIL)
            {
                if(requestCode==EMAIL && resultCode==Activity.RESULT_OK)    
                {
                                if(myFile.exists())
                                    myFile.delete();  
                    Toast.makeText(mActivity, "Mail sent.", Toast.LENGTH_SHORT).show();
                }
                else if (requestCode==EMAIL && resultCode==Activity.RESULT_CANCELED)
                {
                    Toast.makeText(mActivity, "Mail canceled.", Toast.LENGTH_SHORT).show();
                }
                else 
                {
                    Toast.makeText(mActivity, "Please try again.", Toast.LENGTH_SHORT).show();
                }
            }   
        }