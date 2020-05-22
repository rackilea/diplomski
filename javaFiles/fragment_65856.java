Intent intent = new Intent(Intent.ACTION_EDIT);
intent.setType("vnd.android.cursor.item/event");
intent.putExtra("title", "Some title");
intent.putExtra("description", "Some description");
intent.putExtra("beginTime",  cal.getTimeInMillis());
intent.putExtra("endTime",  cal.getTimeInMillis()+60*60*1000);
startActivity(intent);