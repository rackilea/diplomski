public abstract class BasePresenter<V> {

    private V mView;

    public void attachView(V view) { mView = view; }
    public void detachView() { mView = null; }
}

public abstract class BaseFragment<V extends BaseFragment<V, P>, P extends BasePresenter<V>> extends Fragment {

    protected abstract P getPresenter();

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().attachView(this); // unchecked call to 'attachView(V)' as a member of raw type 'BasePresenter'
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenter().detachView();
    }
}

public class MyPresenter extends BasePresenter<MyPresenter.MyView> {
    @Inject
    public MyPresenter() {}

    public interface MyView {}
}

public class MyFragment extends BaseFragment<MyFragment, MyPresenter> implements MyPresenter.MyView {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyFragmentComponent component = ((MainActivity)getActivity()).getComponent().myFragmentComponent();
        component.inject(this);
        View view = inflater.inflate(R.layout.blah, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}