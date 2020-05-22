LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutViewEx);

for (int i = 0; i < result.length(); i++) {
        TextView textView = new TextView(getActivity());           
        textView.setText(result[i]);
        linearLayout.addView(textView);
    }