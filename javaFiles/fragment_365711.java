@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        //other stuff  

}

@LayoutRes
public abstract int getContentViewId();