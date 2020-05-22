public void raiseVolume(View view)
{ float increment = 0.2f; //you set increment here
    rightVolume = ++increment; //then simply increase it by 1
    leftVolume = ++increment;

    //...and so your volume will always be 1.2 at this point
    Log.d("Values","This is the value of volume"+ rightVolume);
}