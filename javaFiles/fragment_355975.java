int hours = TimeUnit.MILLISECONDS.toHours(mTimeLeftInMillis);
int minutes = TimeUnit.MILLISECONDS.toMinutes(mTimeLeftInMillis) % TimeUnit.HOURS.toMinutes(1);
int seconds = TimeUnit.MILLISECONDS.toSeconds(mTimeLeftInMillis) % TimeUnit.MINUTES.toSeconds(1);

String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
mTextViewCountDown.setText(timeLeftFormatted);