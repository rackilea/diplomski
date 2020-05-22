public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private UserViewModel viewModel;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setMessage("Loading...");

        mainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main);
        mainBinding.setLifecycleOwner(this);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        observeLiveData();
        mainBinding.button2.setOnClickListener(v -> {
            viewModel.initLiveData(<your headers>);
            observeLiveData();
        });
    }

    private void observeLiveData() {
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        viewModel.observeRxLiveDate(this, user -> {
            progressDialog.dismiss();
            mainBinding.setUser(user);
        });
    }
}