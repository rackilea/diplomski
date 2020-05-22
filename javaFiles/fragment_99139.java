public class SomeActivity extends Activity implements RowClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        .
        .
        .
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(context,list,this);
    }

    @Override
    public void someFunction(SomeObject someObject){

    }
}

public interface RowClickListener {
    void someFunction(SomeObject someObject);
}