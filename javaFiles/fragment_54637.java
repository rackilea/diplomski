public boolean checkCameraDevice(String str)
{
    if (getPackageManager().hasSystemFeature(str) == false)
    {
         //do something
    }
}