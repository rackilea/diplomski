@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    //set the main view change hello_world to the correct layout_name.xml file
    View v = inflater.inflate(R.layout.hello_world, container, false);

    //set the other views
    ViewHolder viewHolder = new ViewHolder();
    viewHolder.arrowUp = (ImageView) v.findViewById(R.id.iv_arrow_up);
    viewHolder.arrowDown = (ImageView) v.findViewById(R.id.iv_arrow_down);

    ListView menuList = (ListView) v.findViewById(R.id.menu_list);
    menuList.setOnItemClickListener(this);
    menuList.setOnScrollListener(this);
    menuList.setTag(viewHolder);

    MenuItem[] arrayMenuItem = new MenuItem[5];
    arrayMenuItem[0] = new MenuItem(0, "Services", R.mipmap.ic_menu_title_service);
    arrayMenuItem[1] = new MenuItem(1, getString(R.string.get_directions), R.mipmap.ic_directions);
    arrayMenuItem[2] = new MenuItem(2, getString(R.string.amenities), R.mipmap.ic_amenities);
    arrayMenuItem[3] = new MenuItem(3, "Others", R.mipmap.ic_menu_title_other);
    arrayMenuItem[4] = new MenuItem(4, getString(R.string.about), R.mipmap.ic_about);

    menuList.setAdapter(new MenuAdapter(getActivity(), arrayMenuItem));

    return v;
}