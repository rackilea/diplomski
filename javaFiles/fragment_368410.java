View.OnTouchListener listener = new View.OnTouchListener() {
        Runnable runnable;
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            final Handler handler = new Handler();

            View rootView = LayoutInflater.from(mContext).inflate(R.layout.admin_dialog, null);

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // get the first touch in the series
                    start = System.currentTimeMillis();


             runnable = new Runnable(){
                @Override
                public void run(){
                    Toast.makeText(mContext, "This is working", Toast.LENGTH_SHORT).show();
                    mMainContainer.setBackgroundColor(getResources().getColor(R.color.alert_color));
                }
            };
                handler.postDelayed(runnable, 7000);

            }
            if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {

                handler.removeCallbacks(runnable);

                stop += System.currentTimeMillis();

                if ((stop - start) > 7000){

                    // reset values
                    start = 0;
                    stop = 0;

                    final EditText password = (EditText)rootView.findViewById(R.id.admin_password_et);

                    AlertDialog.Builder dialog = new AlertDialog.Builder(mContext)
                            .setView(rootView)
                            .setTitle("Edit Configuration?")
                            .setPositiveButton(R.string.yes_button, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    int counter = 1;
                                    if(password.getText().toString().equalsIgnoreCase("mq")){
                                        Intent intent = new Intent(mContext, MainActivity.class);
                                        startActivity(intent);
                                    } else {
                                        mMainContainer.setBackgroundColor(getResources().getColor(android.R.color.background_light));
                                        Toast.makeText(mContext, "Wrong password, Access denied", Toast.LENGTH_SHORT)
                                        .show();
                                        dialog.dismiss();
                                    }
                                }
                            })
                            .setNegativeButton(R.string.no_button, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mMainContainer.setBackgroundColor(getResources().getColor(android.R.color.background_light));
                                    dialog.dismiss();
                                }
                            });
                    dialog.create();
                    dialog.show();
                } else {

                    // reset values
                    start = 0;
                    stop = 0;
                }
            }

            return true;
        }
    };
    mAppTitle.setOnTouchListener(listener);