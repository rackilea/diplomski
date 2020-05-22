Button btn = (Button)view.findViewById(R.id.btnSave);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Activity myActivity=(Activity)(v.getContext()); // all views have a reference to their context
                SharedPreferences prefs =myActivity.getSharedPreferences(
                        "com.example.app", Context.MODE_PRIVATE);

            }
        });