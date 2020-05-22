public class MainActivity extends Activity {
    ...

    User user = new User();
    EditText name = (EditText)findViewById(R.id.name);
    EditText desg= (EditText)findViewById(R.id.desg);
    EditText id = (EditText)findViewById(R.id.id);

    user.setName(name.getText().toString());
    user.setDesg(desg.getText().toString());
    user.setId(Integer.parseInt(id.getText().toString()));

    ArrayList<User> userlist = new ArrayList<User>();
    userlist.add(user);
}