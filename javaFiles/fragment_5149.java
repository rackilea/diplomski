final EditText searchField = (EditText)findViewById(R.id.searchRecipe);
     searchField.setImeActionLabel("Cerca", KeyEvent.KEYCODE_ENTER);
     searchField.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == KeyEvent.KEYCODE_ENTER) {

                    // do stuff here
                }
                return false;
            }
        });