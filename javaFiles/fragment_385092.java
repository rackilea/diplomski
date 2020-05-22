public void ShowRadioDialog() {
    final CharSequence[] items={"Rosso","Verde","Blu"};
    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setTitle("Seleziona un colore");
    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

        @SuppressLint("NewApi")
        @Override
        public void onClick(DialogInterface dialog, int which) {

        if (index == 1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        getWindow().setStatusBarColor(MainActivity.this.getResources().getColor(R.color.red));
                        toolbar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.red));
                        Toast.makeText(MainActivity.this, "Rosso OK", Toast.LENGTH_SHORT).show();
                        Log.i("Colors", "Rosso Ok");
                    }
            } else if (index ==2) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().setStatusBarColor(MainActivity.this.getResources().getColor(R.color.green_welcome));
                }
            } else if (index == 3){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().setStatusBarColor(MainActivity.this.getResources().getColor(R.color.primary_dark_blue));
                }
            }
        }
    });

    builder.setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {

        @SuppressLint("NewApi")
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // TODO Auto-generated method stub

                if ("Rosso".equals(items[which])) {
                    index = 1;
                } else if ("Verde".equals(items[which])) {

                    index = 2;
                } else if ("Blu".equals(items[which])) {

                    index = 3;
                }

        }
    });
    builder.show();
}