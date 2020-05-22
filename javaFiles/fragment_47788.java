AlertDialog dialog = new AlertDialog.Builder(getActivity()).setTitle("Dialog").setSingleChoiceItems(new String[]{"Item 1", "Item 2"}, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            //Item 1 was selected
                            break;
                        case 1:
                           //Item 2 was selected
                            break;
                    }
                    dialog.dismiss();
                }
            }).create();
dialog.show();