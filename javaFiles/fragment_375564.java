// Sets the image for the three cup, based on the fill level supplied
public void setThreeCupImage(int fillLevel) {

    // make an int array containing the relevant images.
    int[] threeCupLevels = {R.drawable.threecup_level_1,
                            R.drawable.threecup_level_2,
                            R.drawable.threecup_level_3};

    // get reference to an ImageView you've put in you layout xml.
    ImageView threeCupImage = (ImageView)findViewById(R.id.image_threecup);

    // set the ImageView to display the required image from the array.
    threeCupImage.setImageResource(threeCupLevels[fillLevel]);
}