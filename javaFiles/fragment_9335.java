new AlertDialog.Builder(this)
            .setTitle(settingsTitle.getText().toString())
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // continue with delete
                }
            })