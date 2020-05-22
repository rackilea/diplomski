public class MyActivity extends Activity {

    private RealmResults<Person> results; // Strong reference to keep listeners alive

    @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         results = realm.where(Person.class).findAllAsync();
         results.addChangeListener(new RealmChangeListener<RealmResults<Person>>() {
           @Override
           public void onChange(RealmResults<Person> persons) {
               // React to change
           }
       });
     }
     // remove change listeners, and close Realm in onDestroy()
 }