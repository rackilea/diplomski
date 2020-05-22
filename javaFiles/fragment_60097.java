//send item to plugin.
int item = 0; // or whatever it is
Bundle b = new Bundle();
b.put("ident", item);
Intent i = new Intent();
i.putExtras();
//...