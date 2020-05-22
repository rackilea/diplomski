yourBtn = findViewById(R.id.your_btn);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        TypedValue outValue = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        yourBtn.setForeground(getResources().getDrawable(outValue.resourceId, null));
    }