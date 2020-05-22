//Initialise your layout in your activity onCreate()
LinearLayout layout = (LinearLayout) findViewById(R.id.linear_layout);
layout.setOrientation(LinearLayout.VERTICAL);

//Start listening to your firebase data and put this somewhere in the callback:

// poemLines is a list of Strings you get from firebase
for(i=0; i<poemLines.size(); i++){
TextView view = new TextView(context);
view.setText(poemLines.get(i));
//set any other attributes to your textview that you want, width, height, font, etc
view.setGravity(i%2==0?END:START);
layout.add(view);
}