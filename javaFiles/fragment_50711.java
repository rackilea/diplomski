// in OnCreate

Button mClickButton1 = (Button)findViewById(R.id.clickButton1);
mClickButton1.setOnClickListener(this);
Button mClickButton2 = (Button)findViewById(R.id.clickButton2);
mClickButton2.setOnClickListener(this);
Button mClickButton3 = (Button)findViewById(R.id.clickButton3);
mClickButton3.setOnClickListener(this);
Button mClickButton4 = (Button)findViewById(R.id.clickButton4);
mClickButton4.setOnClickListener(this);
Button mClickButton5 = (Button)findViewById(R.id.clickButton5);
mClickButton5.setOnClickListener(this);


// somewhere else in your code

public void onClick(View v) {
    switch (v.getId()) {
        case  R.id.clickButton1: {
            // do something for button 1 click
            break;
        }

        case R.id.clickButton2: {
            // do something for button 2 click
            break;
        }

        //.... etc
    }
}