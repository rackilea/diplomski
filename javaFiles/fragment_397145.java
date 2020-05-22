TextView tv = new TextView(this);
tv.setText("TaskID");
TextView tv1 = new TextView(this);
task = new EditText(this);
task.setMaxWidth(100);
task.setMinHeight(100);
tv1.setText("Task");
id = new EditText(this);
id.setMaxHeight(10);
TextView tv2 = new TextView(this);
name = new EditText(this);

name.setMaxHeight(1);
tv2.setText("Name");


LinearLayout l = new LinearLayout(this);
l.setOrientation(LinearLayout.VERTICAL);
l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));  
setContentView(l);

l.addView(tv);
l.addView(id);
l.addView(tv1);
l.addView(task);
l.addView(tv2);