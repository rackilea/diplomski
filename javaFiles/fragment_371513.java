courseSelection_Button = findViewById( R.id.courseSelection_ButtonXML );
courseSelection_Button.setOnClickListener( new View.OnClickListener() {

    @Override
    public void onClick( View view ) {

        Intent intent = new Intent( Term_ChangingDetails_Activity.this, Term_CourseSelection_Activity.class );
        startActivity( intent );
        finish();

    }
});