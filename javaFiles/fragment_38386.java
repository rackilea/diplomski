Bundle b=new Bundle();
b.putString("key","value you need to retrieve in another activity");
b.putString("name","arjun");
Intent i=new Intent(ctx,Youractivityname.class);
i.putExtras(b); 
StartActiviyt(i);