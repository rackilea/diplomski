public void takePicture()
{
    Intent i_picture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if(i_picture.resolveActivity(getPackageManager())!=null)
    {
        startActivityForResult(i_picture,request);
    }

}