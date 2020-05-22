int sum = 0

EditText name = (EditText)findViewById(R.id.editText);
TextView result  = (TextView)findViewById(R.id.textView);

String y = name.getText().toString();

char[] array = y.toCharArray();
int[] x = new int[y.length()];

for (int i = 0; i < y.length(); i++) {
    char letter = array[i];
    if (letter == 'a') {
        x[i] = 1;
    }
    if (letter == 'b') {
        x[i] = 2;
    }
    if (letter == 'c') {
        x[i] = 3;
    }

    sum = sum + x[i];
}

result.setText(Integer.toString(sum));