knowledgeItemView.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("On Click Listener", currentKey);
                    if(knowledgeCheckBox.isChecked()){
                        knowledgeCheckBox.setChecked(false);
                        prefs.edit().putBoolean(currentKey, false).apply();
                    } else {
                        knowledgeCheckBox.setChecked(true);
                        prefs.edit().putBoolean(currentKey, true).apply();
                    }
                }
            }
    );