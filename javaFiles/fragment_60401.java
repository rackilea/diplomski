package com.example.checkboxes;

      import android.app.Activity;
      import android.os.Bundle;
      import android.view.Menu;
      import android.view.View;
      import android.view.View.OnClickListener;
      import android.widget.CheckBox;
      import android.widget.EditText;
      import android.widget.Toast;

       public class MainActivity extends Activity {
   private CheckBox egg, hotdog, cheese;
       private OnClickListener checkboxclicklistener;
       private EditText display;



@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    egg = (CheckBox) findViewById(R.id.a);
    cheese = (CheckBox) findViewById(R.id.c);
    hotdog = (CheckBox) findViewById(R.id.b);       
    display = (EditText) findViewById(R.id.display);


    createListener(egg);
    createListener(hotdog);
    createListener(cheese);



}

 public void createListener(CheckBox checkbox) {



        checkbox.setOnClickListener( new OnClickListener() {
            StringBuilder checkeditems = new StringBuilder();
            @Override
            public void onClick(View v) {
                 //is checkbox checked?


                if (((CheckBox) v).isChecked()) {

                    String checkboxname = ((CheckBox) v).getText().toString();

                    Toast.makeText(getApplicationContext(), checkboxname, Toast.LENGTH_LONG).show();

                    if(checkboxname.equalsIgnoreCase("egg"))
                    {
                        display.setText(display.getText().toString()+"\nEgg");
                    }

                    else if(checkboxname.equalsIgnoreCase("hotdog"))
                    {
                        display.setText(display.getText().toString()+"\nHotdog");
                    }

                    else if(checkboxname.equalsIgnoreCase("cheese"))
                    {
                        display.setText(display.getText().toString()+"\nCheese");
                    }





                }

                else if (((CheckBox) v).isChecked()==false)
                {
                   String checkboxname = ((CheckBox) v).getText().toString();

                    if(checkboxname.equalsIgnoreCase("egg"))
                    {
                        display.setText(display.getText().toString().replace("\nEgg", ""));
                    }

                    else if(checkboxname.equalsIgnoreCase("hotdog"))
                    {
                        display.setText(display.getText().toString().replace("\nHotdog", ""));
                    }

                    else if(checkboxname.equalsIgnoreCase("cheese"))
                    {
                        display.setText(display.getText().toString().replace("\nCheese", ""));
                    }
                }

              }
            });


 }





@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

  }