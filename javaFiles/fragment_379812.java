// find your framelayout
frameLayout = (FrameLayout) findViewById(....);

// add these after setting up the camera view        

// create a new Button
Button button1 = new Button(this);

// set button text
button1.setText("....");

// set gravity for text within button
button1.setGravity(Gravity.....);

// set button background
button1.setBackground(getResources().getDrawable(R.drawable.....));

// set an OnClickListener for the button
button1.setOnClickListener(new OnClickListener() {....})

// declare and initialize LayoutParams for the framelayout
FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT);

// decide upon the positioning of the button //
// you will likely need to use the screen size to position the
// button anywhere other than the four corners
params.setMargins(.., .., .., ..);

// use static constants from the Gravity class
params.gravity = Gravity.CENTER_HORIZONTAL;

// add the view
fl1.addView(button2, params);

// create and add more widgets

....
....