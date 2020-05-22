private static int previousLevel = 100;

public void onReceive(Context context, Intent intent) {
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int lowLevel = intent.getIntExtra("Level", 0);

            float percentage = level/ (float) scale;
            mProgressStatus = (int)((percentage)*100);
            mViewPercentage.setText("" + mProgressStatus + "%");
            mProgressBar.setProgress(mProgressStatus);

            if (lowLevel < 30 && previousLevel >= 30){

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.lowbattery_toast, (ViewGroup) findViewById(R.id.low_battery));
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0, 10);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);

                toast.show();
            }

            previousLevel = lowLevel;
        }