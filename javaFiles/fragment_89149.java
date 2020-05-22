public class WishlistFragment extends ListFragment {
    private boolean _viewExists = false;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle bundle )
    {
        _viewExists = true
        return super.onCreateView( inflater, container, bundle );
    }

    public void notifyChange()
    {
        if ( _viewExists )
            getListAdapter().notifyDataSetChanged();
    }