book MyBook = new book();
final View book1 = (View) findViewById(R.id.book1);

LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//assuming R.layout.book your book xml
View bookView = inflater.inflate(R.layout.book, null);

//Add bookView layout to your book1.
book1.addView(bookView)