Intent headSetUnPluggedintent = new Intent(Intent.ACTION_HEADSET_PLUG);
 headSetUnPluggedintent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY);
 headSetUnPluggedintent.putExtra("state", 1); // 0 = unplugged  1 = Headset with microphone 2 = Headset without microphone
 headSetUnPluggedintent.putExtra("name", "Headset");
 // TODO: Should we require a permission?
 sendOrderedBroadcast(headSetUnPluggedintent, null);