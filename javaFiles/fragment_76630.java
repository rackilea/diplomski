public class AboutActivity extends Activity {
boolean mIsFromMem;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mIsFromMem=savedInstanceState!=null;
}}