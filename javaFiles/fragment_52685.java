ViewGroup oldGroup = (ViewGroup) findViewById(R.id.some_layout);
ViewGroup newGroup = (ViewGroup) findViewById(R.id.some_other_layout);

Button button = (Button) oldGroup.findViewById(R.id.a_button);

oldGroup.removeView(button);
newGroup.addView(button);