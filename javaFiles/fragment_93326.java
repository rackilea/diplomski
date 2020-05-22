TypedArray backgrounds = getResources().obtainTypedArray(R.array.backgrounds);
int maxIndex = questions.length;
int generatedIndex = rand.nextInt(maxIndex);
screenGame.setBackground(getResources().getDrawable(backgrounds.getResourceId(generatedIndex,-1));
questionText.setText(questions[generatedIndex]);
backgrounds.recycle();