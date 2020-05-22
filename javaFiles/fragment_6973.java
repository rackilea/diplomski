public void steptwo() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.popup_observedproperty,null);

        mPopupWindow = new PopupWindow(
                customView,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );

        String[] countryNameList = {"India", "China", "Australia", "New Zealand", "England", "Pakistan"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(customView.getContext(),
                android.R.layout.simple_dropdown_item_1line, countryNameList);
        AutoCompleteTextView textView = (AutoCompleteTextView) customView.findViewById(R.id.autoCompleteTextView);
        textView.setText("New");
        textView.setAdapter(adapter);
        textView.setThreshold(1);

        if(Build.VERSION.SDK_INT>=21){
            mPopupWindow.setElevation(5.0f);
        }
        mPopupWindow.setFocusable(true);

        mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
    }