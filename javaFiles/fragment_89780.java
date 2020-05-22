butGPA.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v) 
    {
         if (gpa1.isChecked()){calculation = calculation + 1;}
         else{ if (gpa2.isChecked()) {calculation = calculation + 2; }
         else{ if (gpa3.isChecked()) {calculation = calculation + 3; }
         else{ if (gpa4.isChecked()) {calculation = calculation + 4; }
         else{calculation = 0.0; }}}}
        Intent i = new Intent(Main.this, Main2.class);
        i.putExtra("calc", calculation);
        startActivity(i);
    }
});