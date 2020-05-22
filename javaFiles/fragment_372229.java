@Override
    public void onClick(View v) {
        if (v == add_new_dictionary) {
            Intent add_new_dictionary_intent = new Intent(MainActivity.this,
                    add_new_dictionary.class);
            startActivity(add_new_dictionary_intent);
        }
        else (
            Object tag = v.getTag();
            //now launch the detail activity using the data from the tag
        }
    }