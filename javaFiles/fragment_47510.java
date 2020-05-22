String data = editText.getText().toString();
String[] numberStrings = data.split(" ");
int[] numberArray = new int[numberStrings.length];
for (int i = 0; i < numberStrings.length; i++){
    numberArray[i] = Integer.parseInt(numberStrings[i].trim());
}