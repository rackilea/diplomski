ImageButton play = (ImageButton) view.findViewById(R.id.eplay);
play.setTag(cursor.getPosition());
play.setOnClickListener(new OnClickListener(){
@Override
public void onClick(View v) 
{
    int pos = (Integer) v.getTag();
    song(pos+1); 

}
});