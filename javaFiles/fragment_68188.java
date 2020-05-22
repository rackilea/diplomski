View view = getLayoutInflater().inflate(R.layout.your_inflated_layout, null);

    final LinearLayout linearLayout = view.findViewById(R.id.your_linear);
    // Now you can do whatever you want with LinearLayout

    Dialog.OnShowListener showListener = new DialogInterface.OnShowListener() {
        @Override
        public void onShow(DialogInterface dialogInterface) {

            View.OnClickListener hideListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    linearLayout.setVisibility(View.INVISIBLE);

                }
            };

            View.OnClickListener unHideListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    linearLayout.setVisibility(View.VISIBLE);

                    // Hiding LinearLayout but this doesn't
                    // dismiss the dialog if you want
                    // call dialogInterface.dismiss();
                }
            };

            // Overriding AlertDialog's Button because we don't want it
            // to dismiss in every click
            Button hide = ((AlertDialog) dialogInterface).getButton(AlertDialog.BUTTON_POSITIVE);
            Button unhide = ((AlertDialog) dialogInterface).getButton(AlertDialog.BUTTON_NEGATIVE);
            hide.setOnClickListener(hideListener);
            unhide.setOnClickListener(unHideListener);
        }
    };

    AlertDialog.Builder builder = new AlertDialog.Builder(this)
            .setView(view)
            .setPositiveButton("Hide", null)
            .setNegativeButton("Unhide", null);

    AlertDialog dialog = builder.create();
    dialog.setOnShowListener(showListener);
    dialog.show();