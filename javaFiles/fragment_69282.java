.setMultiChoiceItems(_options, _selections, new DialogInterface.OnMultiChoiceClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int clicked, boolean selected) {
                        _selections[clicked] = selected;
                        Log.i("Database", _options[clicked] + " selected: " + selected);
                }

        })