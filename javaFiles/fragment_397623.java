public class MyFragment extends Fragment {
    private Context mContext;
    private Button mButton;

    public MyFragment(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(...) {
        ...

        mButton.setOnClickListener(v->{
            ((MyActivity)mContext).switchTab(1);
        });

        ...
    }
}