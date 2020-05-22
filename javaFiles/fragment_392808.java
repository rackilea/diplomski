//implement MyPresenterIView to your Activity or Fragment 
public class MyActivity extent SomeActivity implements MyPresenterIView{
private MyPresenter myPresenter;

//in onCreate or onCreateView(if its  a fragment) initialize myPresenter
protected void onCreate(..){
myPresenter=new MyPresenter(this);//this will enforce Activity/Fragment to implement IView
}


@Override //comes from MyPresenterIView
public String getFieldOneText(){
return ((EditText)findViewById(R.id.edttext_field_one)).getText().toString().trim();
}
}