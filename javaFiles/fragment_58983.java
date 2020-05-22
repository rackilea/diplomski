int count = 10; //leads to ten buttons
boolean[] colorBool = new boolean[count];
Button[] buttons = new Button[count];

for(int i = 0; i < colorBool.length; i++) {
    if(colorBool[i]) {
        buttons[i].setBackgroundColor(Color.GREEN);
    }
    else {
        buttons[i].setBackgroundColor(Color.RED);
    }
}