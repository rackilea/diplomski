ViewGroup parent = (ViewGroup)findViewById(R.id.PARENT_ID_HERE);
Button but[] = new Button[31];
for(int i=1;i<32;i++)
{
    but[i] = new Button(this);
    // set listeners and stuff
    parent.addView(but[i]);
}