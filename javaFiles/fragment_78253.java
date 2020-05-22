Next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            Intent splash = new Intent(MainActivity.this, NextActivity.class);
                startActivity(splash);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
              ButterKnife.apply(allButtons, ADDLISTENER);
            }
        });