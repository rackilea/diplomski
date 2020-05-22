@Override
public void onActivityResult(int requestCode,int resultCode,Intent data)
{
     super.onActivityResult(requestCode, resultCode, data);
     String extraData=data.getStringExtra("ComingFrom"));
}