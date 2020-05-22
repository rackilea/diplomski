TextView animateTextView = (TextView) findViewById(R.id.textview);

 ObjectAnimator textViewAnimator = ObjectAnimator.ofFloat(animateTextView, "translationY",0f,500f);
 textViewAnimator.setDuration(2000);
 textViewAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
 textViewAnimator.start();