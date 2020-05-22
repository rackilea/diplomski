public class MyClass extends Activity implements OnClickListener   
{   
protected void onCreate(Bundle savedInstanceState)   
{     
super.onCreate(savedInstanceState);   

    btn1. setOnClickListener( new OnClickListener()   
    {    
      public void onClick( View v )   
      {   
        //add action for btn1.   

      }   
   });   

  btn2.setOnClickListener( this );   

}   

public void onClick( View v )   
{   

if( v== (Button)findViewById( R.id.btn2_id )   
{  

  //perform action for btn2. 

}  

}  

}