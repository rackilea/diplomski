Bitmap bmpLogo = Bitmap.getBitmapResource("yourImage.jpg");
BitmapField logo = new BitmapField(bmpLogo){
    protected boolean trackwheelClick(int status, int time)
    {   
        // Your onclick code here
        return true;
    }
};
add(logo);