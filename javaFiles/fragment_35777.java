public void onClick(View v)
    {
        v.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == tv)
                    mLink = "link1";
                else if(v == tv1)
                    mLink = "link2";
                else if(v == tv2)
                    mLink = "link3";

                v.startAnimation(myscale);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(mLink));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } catch (Exception e) {
                            Log.e("Exception Caught", e.toString());
                        }
                    }
                }, 50);
            }
        });
    }