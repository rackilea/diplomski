@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    for(int i=0;i<itemsChecked.length;i++){
        if(selected_categories.contains((String)String.valueOf(i)))
            itemsChecked[i]=true;
    }

    // Set the dialog title
    builder.setTitle("Choisissez vos paramètres")
            .setMultiChoiceItems(R.array.categories, itemsChecked,
                    new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int indexselected,
                                            boolean isChecked) {
                            if (isChecked) {
                                // If the user checked the item, add it to the selected items
                                if(!selected_categories.contains(indexselected)){
                                    selected_categories.add(indexselected);
                                    itemsChecked[indexselected]=true;
                                }
                            } else if (selected_categories.contains(indexselected)) {
                                // Else, if the item is already in the array, remove it
                                selected_categories.remove(indexselected);
                                itemsChecked[indexselected]=false;
                            }
                        }
                    })
                    // Set the action buttons
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    mlistener.onOkay(selected_categories);
                }
            })
            .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    mlistener.onCancel();
                }
            });
    return builder.create();
}