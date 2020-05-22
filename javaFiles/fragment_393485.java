private void setSingleEvent(GridLayout mainGrid){
        for(int i = 0;i<mainGrid.getChildCount();i++){
            final int finalI = i;
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String layoutID = "unit"+ (finalI + 1) + "Layout";
                    ConstraintLayout constraintLayout = findViewById(getResources()
                            .getIdentifier(layoutID,"id",getPackageName()));
                    Log.d("unit i layout", "unit"+ (finalI + 1) + "Layout");
                    if(unitNumbers[finalI+1] == 0) {
                        unitNumbers[finalI+1] = finalI+1;

                        constraintLayout.setBackground(ContextCompat
                                .getDrawable(constraintLayout.getContext(),R.drawable.cardbackgroundselected));
                    }
                    else {
                        unitNumbers[finalI+1] = 0;
                        constraintLayout.setBackground(ContextCompat
                                .getDrawable(constraintLayout.getContext(),R.drawable.cardbackground));

                    }
                }
            });
        }
}