private AlertDialog.Builder builder;
     private void showAlert(int id){
            switch (id) {
            case DIALOG_GAMEOVER_ID:
                    builder.setMessage("GAME OVER")
                    .setCancelable(false)
                    .setPositiveButton("Go To Main", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        Intent myIntent = new Intent(view.getContext(),MainUI.class);
                        startActivity(myIntent);


                        }
                    }).setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        Intent myIntent = new Intent(view.getContext(),Custom.class);
                        startActivity(myIntent);


                        }
                    });

                    builder.create();
                    builder.show();
                    break;
              }

         }