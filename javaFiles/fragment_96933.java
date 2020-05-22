// Load the ImageView that will host the animation and
 // set its background to our AnimationDrawable XML resource.
 ImageView img = (ImageView)findViewById(/*resourceImageID e.g. AfadeOut03*/);
 img.setBackgroundResource(/*backgroundResource*/);

 // note that this loads the resource from an XML file, but
 // instead of getting the resource from file you can generate
 // it from a single image by performing the required modifications
 // of the image and storing them in a resource.

 // Get the background, which has been compiled to an AnimationDrawable object.
 AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

 // Start the animation
 frameAnimation.setOneShot(true);// don't loop if not set in XML
 frameAnimation.start();