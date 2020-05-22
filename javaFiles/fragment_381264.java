long[] pattern = { 0, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
int[] mAmplitudes = new int[]{0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0};

  v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Log.d("VIBRATE ===>", "I AM VIBRATING");


                    VibrationEffect effect = VibrationEffect.createWaveform(pattern, mAmplitudes, 0); //This do work on Android 9
                    v.vibrate(effect);




            } else {
                Log.d("VIBRATE ====>", "I AM VIBRATING");


                v.vibrate(pattern , 0); //This do work on Android 6
            }