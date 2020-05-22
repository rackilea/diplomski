final EditText Name = (EditText) findViewById(R.id.Playername);
class MyKeyListener implements View.OnKeyListener {
    @Override
    public boolean onKey (View v, int keyCode, KeyEvent event) {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                (keyCode == KeyEvent.KEYCODE_ENTER)) {

            String name = Name.getText().toString();
            if (Name.length() > 0) {
                list.add(name);
                adapter.notifyDataSetChanged();
                Name.getText().clear();
            }
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(textInput.getWindowToken(), 0);  

            return true;
        }
        return false;
    }          

}

Name.setOnKeyListener(new MyKeyListener());
Add.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        String name = Name.getText().toString();
        if (Name.length() > 0) {
            list.add(name);
            Name.getText().clear();
            adapter.notifyDataSetChanged();
            hideSoftKeyboard(LoginPage.this);
        }
    }
    public void hideSoftKeyboard(LoginPage theActivity) {
        final InputMethodManager inputMethodManager = (InputMethodManager) theActivity.getSystemService(LoginPage.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            if (theActivity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(theActivity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }
});

Reset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        list.clear();

    }
});

Sgame.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(!list.isEmpty())
            openActivity2();
    }
});

information.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.informationpopup, null);

        popupWindow = new PopupWindow(container, 1150, 2000, true);
        popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 140, 300);

        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });

        }
    });
}

public void openActivity2() {
    Intent intent = new Intent(this, Gamescreen.class);
    String s= list.get(0);
    intent.putExtra("Name1", s);
    startActivity(intent);
}}