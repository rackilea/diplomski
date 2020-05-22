btnSave.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View view) {
            StudentRepo repo = new StudentRepo(StudentDetail .this);
            Student student = new Student();
            student.name = txtEditName.getText().toString();
            student.father_name = txtEditFather.getText().toString();
            student.mother_name = txtEditMother.getText().toString();
            student.age = Integer.parseInt(txtEditAge.getText().toString());
            student.student_class = txtEditClass.getText().toString();
            student.student_id =_student_id;

            if (_student_id==0){
                _student_id = repo.insert(student);

                Toast.makeText(this,"New Student Insert",Toast.LENGTH_SHORT).show();
            }
   }
});

btnBack.setOnClickListener(new View.OnClickListener() {

   @Override
   public void onClick(View view) {
         finish();
   }
});