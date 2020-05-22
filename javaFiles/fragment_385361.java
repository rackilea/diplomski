TextView[] myTextViews = new TextView[names.size()];
for (int i = 0; i < names.size(); i++) {
     myTextViews[i] = new TextView(this);
     myTextViews[i].setText(names.get(i));
}
for (int i = 0; i < names.size(); i++) {
    final TextView thisOne = myTextViews[i];
    if (i%3 == 0) {
        final TextView nextOne = myTextViews[i+1];
        thisOne.setOnClickListener(new View.onClickListener() {
            @Override
            public void onClick(View v) {
                thisOne.setBackgroundColor(Color.GREEN);
                nextOne.setBackgroundColor(Color.GREEN);
            }
        });
    } else if ((i-1)%3 == 0) {
        final TextView previousOne = myTextViews[i-1];
        thisOne.setOnClickListener(new View.onClickListener() {
            @Override
            public void onClick(View v) {
                thisOne.setBackgroundColor(Color.GREEN);
                previousOne.setBackgroundColor(Color.RED);
            }
        });
    }
}