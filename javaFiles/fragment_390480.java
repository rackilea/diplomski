for(int i= 0; i<packageList.size(); i++){
            PACKAGE_NAME = packageInfo.packageName;

            sharedPrefs = context.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);
            Log.d("just got sharedpref??", PACKAGE_NAME);


            holder.ck1.setChecked(sharedPrefs.getBoolean(PACKAGE_NAME,false));
            Log.d("just got boolean??", PACKAGE_NAME);


        }

        holder.ck1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                SharedPreferences.Editor editor = context.getSharedPreferences(packageInfo.packageName, Context.MODE_PRIVATE).edit();

                if (holder.ck1.isChecked()) {
                    itemChecked[position] = true;
                    holder.ck1.setChecked(true);
                    Log.i("This is", " checked: " + position);
                    editor.putBoolean(packageInfo.packageName, true);
                    Log.d("put true", packageInfo.packageName);

                    editor.apply();

                } else {
                    itemChecked[position] = false;
                    holder.ck1.setChecked(false);
                    Log.i("This is", " not checked: " + position);
                    editor.putBoolean(packageInfo.packageName, false);
                    Log.d("put false", packageInfo.packageName);

                    editor.apply();

                }

            }


        });