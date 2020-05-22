try {
    String counter = ((TextView)textView ).getText().toString();
    calculatedValue = Integer.parseInt(counter) + 1;
    ((TextView)textView ).setText(String.valueOf(calculatedValue));
}catch (Exception e){
    e.printStackTrace();
}