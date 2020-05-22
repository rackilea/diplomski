public static ConstraintLayout createConstraintLayoutWithButton(Context context){

  Constraintlayout mylayout = new ConstraintLayout(context);
  //set up of the layout
  Button myButton = new Button(context);
  //set up of the button
  button.setId(R.id.emailSignInButton);
  myLayout.addView(button);
  return mylayout;
}