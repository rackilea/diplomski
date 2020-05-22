public class myActivity extends Activity{

Context mContext;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mContext = this;

    String username = KeyValueDB.getUsername(mContext);
}