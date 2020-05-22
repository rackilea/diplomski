protected void startCameraActivity() 

{

    // TODO Auto-generated method stub
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE );
        intent.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );

        startActivityForResult( intent, 0 );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {   
        switch( resultCode )
        {
            case 0:
                break;

            case -1:
                onPhotoTaken();
                break;
        }
    }

    protected void onPhotoTaken()
    {

        ///write code here what you want to done after capture the image using device camera
    }

    @Override 
    protected void onRestoreInstanceState( Bundle savedInstanceState)
    {
        if( savedInstanceState.getBoolean( add_project1.PHOTO_TAKEN ) ) 
        {
            onPhotoTaken();
        }
    }

    @Override
    protected void onSaveInstanceState( Bundle outState ) 
    {
        outState.putBoolean( add_project1.PHOTO_TAKEN, _taken );
    }