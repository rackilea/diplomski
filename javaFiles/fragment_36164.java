TextView secondTV = findViewById(R.id.secondTextView);
TextView firstTV = findViewById(R.id.firstTextView);
LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 3);
LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);

firstTV.setLayoutParams(layoutParams);
secondTV.setLayoutParams(layoutParams1);