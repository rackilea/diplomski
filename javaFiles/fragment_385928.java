LinearLayout yourlayout= (LinearLayout) findViewById(R.id.yourlayout);

for (int i = 0; i < arraylist.size(); i++) {

                    Button btn = new Button (ActivityName.this);
                    btn.setWidth(40);
                    btn.setHeight(20);
                    btn.setText(arrylist.get(i).gettext());
                    yourlayout.addView(btn);
                }