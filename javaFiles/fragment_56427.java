public void jumpTo(View i)
{
textActivity = spinner_activity.getSelectedItem().toString();
if(textActivity.equals("Entree"){
                Intent i = new Intent(this, BadgeEntree.class);
                startActivity(i);
            }
            else
            {
            Log.d("Else","Wrong");
            }
}