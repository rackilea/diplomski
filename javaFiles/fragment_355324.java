// Grabbing all the LinearLayout views found under view with with id of 'content' 
ArrayList<LinearLayout> linearLayouts = solo.getCurrentViews(LinearLayout.class, solo.getView(R.id.content));

// The 4th item in the linearLayouts list is the one I need
View pickerList = linearLayouts.get(3);

// Grabbing the buttons in the pickerList
ArrayList<TextSwitcher> buttons = solo.getCurrentViews(TextSwitcher.class,pickerList);

// Now I can click on the buttons
solo.clickOnView(buttons.get(0));