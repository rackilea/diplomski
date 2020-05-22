public class test extends FragmentActivity implements textEntered {

    String value;
    boolean check = false;
    BottomFragment frg2;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Top_Fragment frg = new Top_Fragment();
        frg2 = new BottomFragment();

        FragmentManager manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.My_Container_1_ID, frg, "Frag_Top_tag");
        transaction.add(R.id.My_Container_3_ID, frg2, "Frag_Bottom_tag");
        transaction.commit();
    }

    @Override
    public void setValue(String editextvalue) {
        value = editextvalue;
        if (frg2 != null) {
            frg2.setName(value);
        } else {
            Toast.makeText(getApplicationContext(), "fragment 2  is null", 1000).show();
        }
    }

}