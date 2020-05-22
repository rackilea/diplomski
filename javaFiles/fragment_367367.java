AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final SharedPreferences preferences = getSharedPreferences("type_settings", MODE_PRIVATE);

        final String[] availableTypes = getResources().getStringArray(R.array.select_type_items);
        final boolean[] selectedTypes = getSelectedTypes(preferences, availableTypes);

        builder.setIcon(R.drawable.menu_type)
                .setTitle(R.string.list_dialog_title)
                .setMultiChoiceItems(R.array.select_type_items, selectedTypes,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton, boolean isChecked) {
                                selectedTypes[whichButton] = isChecked;
                            }
                        })
                .setPositiveButton(R.string.types_save, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        SharedPreferences.Editor prefEditor = preferences.edit();
                        saveSelectedTypes(prefEditor, availableTypes, selectedTypes);
                    }
                })
                .setNegativeButton(R.string.types_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                })
                .create();
        builder.show();