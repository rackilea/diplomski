@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
if(view != null)
    {
        ViewGroup parent = (ViewGroup) view.getParent();
        if(parent != null)
        {
            parent.removeView(view);
        }
    }
    try
    {
        view = inflater.inflate(R.layout.fragment_places, container, false);
    }
    catch(InflateException e){
        // map is already there, just return view as it is
    }
    return view;