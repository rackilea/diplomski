//retrieve the bundle
Bundle bundle = getArguments(); //retrieve the bundle
String bundleText = bundle.getString("USER"); //get the data on the bundle

//find view & set the text
usernameTextView = (TextView) view.findViewById(R.id.usernametext);
usernameTextView.setText(bundleText);