Values class extends MainActivity so no need to create interface.You can call any method of MainActivty directly just using method name.Even you can override any method of MainActivty in your Values class.

public class MainActivity extends Activity 
{
public String caption="";

//Method 1           
public void setCaption(String caption)
{
this.caption=caption
}
//Method 2           
public String getCaption()
{
return caption;
}

}

public class Values extends MainActivity 
{
setCaption("Test Application");
Toast.makeText(getApplicationContext(),getCaption(),Toast.LENGTH_SHORT).show();
}