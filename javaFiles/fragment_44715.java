dialogLayout.addView(msg1);
    dialogLayout.setOrientation(LinearLayout.VERTICAL);
    AlertDialog welcome = new AlertDialog.Builder(Welcome.this).create();
    ScrollView scrollPane = new ScrollView(this);
    scrollPane.addView(dialogLayout);
    welcome.setView(scrollPane);