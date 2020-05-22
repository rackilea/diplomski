public void buttonClick() {
    final CourseNameClass courseNameShared = new CourseNameClass(" ");

    Button enterAnotherButton = (Button) findViewById(R.id.enterAnotherButton);
    enterAnotherButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            EditText inputText = (EditText)findViewById(R.id.inputCourseName);
            String courseNameString = inputText.getText().toString();
            courseNameShared.courseNameInClass = courseNameString;
            inputText.setText("");
        }
    });

    Button doneButton = (Button) findViewById(R.id.doneButton);
    doneButton.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        Intent i = new Intent(EnterCourseActivity.this, MainActivity.class);
        i.putStringArrayListExtra("course", courseNameShared.getCoursesArrayList());

        startActivity(i);
    }
}


class CourseNameClass {
    String courseNameInClass;

    public CourseNameClass(String courseNameInClass){
        this.courseNameInClass = courseNameInClass;
    }

    public ArrayList<String> getCoursesArrayList() {
        ArrayList<String> coursesArrayListInClass = new ArrayList<String>();
        coursesArrayListInClass.add(courseNameInClass);
        return coursesArrayListInClass;
    }
}