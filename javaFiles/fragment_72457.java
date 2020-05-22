button.setOnClickListener(new View.OnClickListener(){

          public void onClick(View view){

            Uri packageUri = Uri.parse("package:com.exaample.test");

            Intent uninstallIntent =
              new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageUri);
            startActivity(uninstallIntent);
          }
        });