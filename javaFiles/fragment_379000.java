MyActivity:
...

           EditText fn = (EditText) findViewById(R.id.firstName);
           EditText ln = (EditText) findViewById(R.id.lastName);
           EditText ad = (EditText) findViewById(R.id.address);
           EditText c = (EditText) findViewById(R.id.city);
           //pass as parameter into constructor or method.
           Helper helper = new Helper(fn, ln, ad, c);
           helper.myRegisterMethod();

           //or
           helper.myRegisterMethod(fn, ln, ad, c);
           ...        


public class Helper {

//class constructor
    public Helper (fn, ln, ad, c)
    {

        this.fn = fn;
        etc
    }

    myRegisterMethod(){
    //or
    myRegisterMethod(fn, ln, ad, c){
          //to do       

    }
}