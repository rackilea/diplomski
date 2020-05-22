ArrayList<Integer> options = new ArrayList<Integer>();
options.add(R.string.bacon);
options.add(R.string.ham);

//R.id.option1 is in my layout and R.string.bacon is in my strings.xml
TextView option1 = (TextView)findViewById(R.id.option1);
option1.setText(options.get(0));