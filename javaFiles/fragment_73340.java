final RelativeLayout unreadCount = (RelativeLayout) findViewById(R.id.header_navigation);

if(_preferences.getBoolean(UNREAD_COUNT_ENABLED_KEY, false)){
   unreadCount.setVisibility(View.VISIBLE);
}else{
   unreadCount.setVisibility(View.GONE);
}