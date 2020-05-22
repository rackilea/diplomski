boolean enterPressed = false;    

@Override
public void onClick(View v) {
    TextView vector = (TextView) findViewById(R.id.point);
    TextView index = (TextView) findViewById(R.id.index);
    TextView info = (TextView) findViewById(R.id.info);
    EditText cl = (EditText) findViewById(R.id.editText1);
    DrawingUtils call = new DrawingUtils();
    switch (v.getId()) {
    case R.id.line:
        if (enterPressed) {
            vector.setText(call.addVertice());
            index.setText("1");
        }
        else {
            info.setText("Input X,Y,Z");
        }

        break;
    case R.id.enter:
        String In = cl.getText().toString();
        call.setInputCoords(In);
        enterPressed = true;
        break;
    case R.id.arc:
        info.setText("Enter Vertice1 ");
        // Code for entering Vertice1
        info.setText("Enter Vertice2");
        // Code for entering Vertice2

    }

}