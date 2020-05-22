public class MyActivity extends Activity{

     ListView mListView;
     ArrayAdapter<User> mAdapter;

     public void onCreate(Bundle savedInstanceState){
          super.onCreate(savedInstanceState);
          setContentView(R.layout.main);

          //get the listview from xml. I think you know how to layout half and half...
          mListView = (ListView)findViewById(R.id.list);
          mAdapter = new ArrayAdapter<User>(this,R.id.userviewlayout){

               @Override
               public View getView(){
                    //here is where you add the code to inflate and display a view for a single user
               }
          };

          for(User user : Users)
               mAdapter.add(user);

          mListView.setAdapter(mAdapter);
     }
}