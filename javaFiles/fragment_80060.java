String inputText = Input.getText().toString();

String[] numberStrings = inputText.split(" ");

num = new int[numberStrings.length()];
for (int i = 0; i < numberStrings.length(); i++){
    num[i] = Integer.parseInt(numberStrings[i]);
}