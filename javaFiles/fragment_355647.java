Bundle bundle = shortcutIntent.getExtras();

Parcel parcel = Parcel.obtain();
bundle.writeToParcel(parcel, 0);
byte[] byt = parcel.marshall();

String s = Base64.encodeToString(byt, 0, byt.length, 0); //store this string to sqlite
byte[] newByt = Base64.decode(s, 0);

Bundle newBundle = new Bundle();
Parcel newParcel = Parcel.obtain();
newParcel.unmarshall(newByt, 0, newByt.length);
newParcel.setDataPosition(0);
newBundle.readFromParcel(newParcel);

Intent intent = new Intent();
intent.putExtras(newBundle);

MainActivity.getContext().startActivity((Intent)intent.getExtras().get(Intent.EXTRA_SHORTCUT_INTENT));