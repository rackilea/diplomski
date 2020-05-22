.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    fret = input.getText().toString();
                    button.setText(fret);
                }
            })