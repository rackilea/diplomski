public class AboutFragment extends Fragment {

    // ...

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.about_layout, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        toolbar.inflateMenu(R.menu.menu_about_fragment);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.some_menu) {
                    // do sth...
                    return true; // event is handled.
                }
                return false;
            }
        });

        // ...
    }

    // ...
}