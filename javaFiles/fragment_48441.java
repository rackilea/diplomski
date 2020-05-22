EditText xE, yE;

float x, y;

int[] xIds = { R.id.x1et, R.id.x2et, /*...etc*/ };
int[] yIds = { R.id.y1et, R.id.y2et, /*...etc*/ };

for(int i = 0; i < xIds.length && i < yIds.length; i++) {
    xE = (EditText)findViewById(xIds[i]);
    yE = (EditText)findViewById(yIds[i]);
    try { 
        x = Float.parseFloat(xE.getText().toString());
        y = Float.parseFloat(yE.getText().toString());
        //do whatever you need with the data here
    } catch (NumberFormatException e) {
        //Either there was an invalid input, or field was empty
        //You can add extra logic here to check them for empty fields
        //or just exit the loop here
    }
}