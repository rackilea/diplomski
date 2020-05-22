// create the Activity's view
View root = LayoutInflater.from(this).inflate(R.layout.myLayout, null);
// set the view
setContentView(root);
// find another view by the tag of the root view
Button b = (Button) root.findViewWithTag("someTag");