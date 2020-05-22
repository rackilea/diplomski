@Override
public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    MyBinding binding = DataBindingUtil.setContentView(this,
            R.layout.my, new MyComponent());
    binding.setData(/* whatever */);
}