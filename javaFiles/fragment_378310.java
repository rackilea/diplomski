findViewById(R.id.ratebutton).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "market://details?id=<package_name>";

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });