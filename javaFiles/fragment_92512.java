//currentLevel and correctAnswer vars
private int currentlevel;
private int correctAnswer;

@Override
protected void onCreate(Bundle savedInstanceState) {
   //load all your UI
}

private void levelTransition()
{
   //for each level, load specific text and images
   switch(currentlevel)
   case 1:
   String pregunta=("Quin element és el Hidrògen?");
   tvPregunta.setText(pregunta);
   //... and other things
   correctAnswer = (...) //load here the id of the correct answer of each level
   break;
   case 2:
   //...
}

@Override
public void onClick(View v) {

    //when clicking the correct id, transict to other level, and load new data
    if(v.getId() == correctAnswer)
            {
            Toast.makeText(getBaseContext(), "Correcte!", Toast.LENGTH_SHORT).show();
            currentlevel++;
            levelTransition();
            }
    else
            {
            Toast.makeText(getBaseContext(), "Error!! :(", Toast.LENGTH_SHORT).show();
            break;
            }