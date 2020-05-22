Button b1 = (Button)findViewById(R.id.bChoice1);
Button b2 = (Button)findViewById(R.id.bChoice2);
Button b3 = (Button)findViewById(R.id.bChoice3);
Button b4 = (Button)findViewById(R.id.bChoice4);
Button b5 = (Button)findViewById(R.id.bChoice5);

// assuming textList is an ArrayList of text items
// the next two lines will randomize your textList order
// so you don't need to do it yourself and much less
// error-prone
long seed = System.nanoTime();
Collections.shuffle(textList, new Random(seed));

b1.setText(textList.get(0));
b2.setText(textList.get(1));
b3.setText(textList.get(2));
b4.setText(textList.get(3));
b5.setText(textList.get(4));