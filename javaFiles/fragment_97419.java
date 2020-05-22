Intent shortcutIntent = new Intent (this, YourActivity.class);      
Intent addIntent = new Intent(); 
addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Title"); 
addIntent.putExtra("duplicate", false); 
addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(this, R.drawable.icon)); 

sendBroadcast(addIntent);