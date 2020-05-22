public class MyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private Test mListener;

    public interface Test{
        void imLeavingYou();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (Test) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mListener != null){
            mListener.imLeavingYou();
        }
    }
}