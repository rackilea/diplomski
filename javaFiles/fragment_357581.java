public class Register extends Activity{
        EditText et_name,et_user_name,et_user_pass;
        Button btn_register;
        String name,userName,userPass;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.your_xml_file);

            et_name= (EditText) findViewById(R.id.name);
            et_user_name= (EditText) findViewById(R.id.username);
            et_user_pass= (EditText) findViewById(R.id.password);
            btn_register= (Button) findViewById(R.id.submitbutton);


        }
    }