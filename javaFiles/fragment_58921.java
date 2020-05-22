Intent intent=getIntent();
if(intent.getExtras()!=null)
{    
   if(id>=0&&intent.getExtras().get(EXTRA_MESSAGE)==null) {
       return PageFragment.newInstance(id);
   }else if(id==0&&intent.getExtras().get(EXTRA_MESSAGE)!=null){
       int drinkID = (Integer) intent.getExtras().get(EXTRA_MESSAGE);
       return PageFragment.newInstance(drinkID);}
    else{
       return PageFragment.newInstance(id);
   }
}