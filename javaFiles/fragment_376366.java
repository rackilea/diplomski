String str=getKey();
String str2=mTextView.getText().toString();
if(numKey==0)//numkey is the number of valid presses
{
    String toSet="0"+str+":00";
    mTextView.setText(toSet);
}
else if(numKey==1)
{
    String toSet=str+str2.substring(1);
    mTextView.setText(toSet);
}
//and so on...