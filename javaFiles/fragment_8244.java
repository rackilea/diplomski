public class AsteroidsFragment extends Fragment implements RadiusProvider { 
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         ...
        asteroidsView = (AsteroidsView) view.findViewById(R.id.asteroidsView);
        asteroidsView.setRadiusProvider(this);
        return view;
    }

    @Override
    public int getDiffRadius() {
        return diffRadius;
    }