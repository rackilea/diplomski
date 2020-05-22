//global static vars
static int count1=0;
static int count2=0;
static int count3=0;
static int count4=0;

//make sure you include your conditions. I've added this just for reference
public void addListenerOnButton() {  
  a1.setOnClickListener(new OnClickListener() {  
@Override public void onClick(View v)  
  {
  count1++;
  }
}

a2.setOnClickListener(new OnClickListener() {  
  @Override public void onClick(View v)  
 {
  count2++;
  }
}

//And so on...
}   

 public void checkFunc()
{
if(count1==count2==count3==count4)
  {
  //do something
  }
}