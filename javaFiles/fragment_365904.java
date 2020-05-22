private class MyOnClickListener implements OnClickListener{
@Override
public void onClick(View v)
{
int id=v.getId();
Intent i=new Intent(Test1Activity.this,Sanjay.class); 
i.putExtra(pass, id);
startActivity(i);

}

}