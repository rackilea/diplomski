//variables
float leftVolume = 0.5f;
float rightVolume = 0.5f;

public void raiseVolume(View view)
{ float increment = 0.2f;
    rightVolume += increment; //change this line to this
    leftVolume += increment;  //change this line to this
    Log.d("Values","This is the value of volume"+ rightVolume);
}