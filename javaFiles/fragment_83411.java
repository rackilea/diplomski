public void question3(View view) {

    // Get the typed answer by the user and convert it to lower case.
    EditText question3 = (EditText) findViewById(R.id.question3_typed); 

    String question3_answer = question3.getText().toString().trim().toLowerCase();

    if (question3_answer.equals("angry")) {
        answer3 = "correct";
    } else answer3 = "wrong";