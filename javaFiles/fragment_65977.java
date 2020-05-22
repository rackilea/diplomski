import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;

    public class Main2Activity extends AppCompatActivity {

       Button goButton;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.emp);
            goButton=(Button)findViewById(R.id.goButton);
            goButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent i=new Intent(Main2Activity.this,SaveadminActivity.class);
            startActivity(i); 
                }
            });
        }

    }