spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                 Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/fontname");
                 textview.setTypeface(custom_font);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });