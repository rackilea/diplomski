float x =event.values[0];
float y =event.values[1];
float z =event.values[2];
acelLast=acelVal;
acelVal=(float) Math.sqrt((double) (x*x)+(y*y)+(z*z));
float delta= acelVal-acelLast;
shake =shake*0.9f+delta;


if(shake>20){
    ((EditText) findViewById(R.id.pBox)).setText("");
    ((EditText) findViewById(R.id.aBox)).setText("");
    ((EditText) findViewById(R.id.iBox)).setText("");
    ((TextView) findViewById(R.id.output)).setText("");
}