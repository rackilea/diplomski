// Create the LayoutParams
RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

// Add all the rules you need
params.addRule(RelativeLayout.ALIGN_PARENT_END);
...

// Once you are done set the LayoutParams to the layout
relativeLayout.setLayoutParams(params);