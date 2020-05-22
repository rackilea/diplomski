Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
synchronized (this) {
            i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_MEDIA_NEXT));
            sendOrderedBroadcast(i, null);

            i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP,     KeyEvent.KEYCODE_MEDIA_NEXT));
            sendOrderedBroadcast(i, null);
 }