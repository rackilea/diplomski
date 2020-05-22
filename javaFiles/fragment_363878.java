PackageManager packageManager;
    ListView apkList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.user_installed, container, false);
        packageManager = getActivity().getPackageManager();


        /*To filter out System apps*/

        apkList = (ListView) rootView.findViewById(R.id.applist);

        new LoadApplications(getActivity().getApplicationContext()).execute();


        return rootView;
    }

    /**
     * Return whether the given PackageInfo represents a system package or not.
     * User-installed packages (Market or otherwise) should not be denoted as
     * system packages.
     *
     * @param pkgInfo
     * @return boolean
     */
    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true
                : false;
    }

    private boolean isSystemPackage1(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) ? false
                : true;
    }


// Don't need in Fragment
/*@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.block, menu);
   // super.onCreateOptionsMenu(menu,inflater);
}*/

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }


    private class LoadApplications extends AsyncTask<Void, Void, Void> {

        Context mContext;

        private ProgressDialog pDialog;
        List<PackageInfo> packageList1 = new ArrayList<PackageInfo>();

        public LoadApplications(Context context){
            Context mContext = context;
        }




        @Override
        protected Void doInBackground(Void... params) {

            List<PackageInfo> packageList = packageManager
                    .getInstalledPackages(PackageManager.GET_PERMISSIONS);


          /*  List<ApplicationInfo> list = mContext.getPackageManager().getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);


            for(int n = 0;n<list.size();n++){
                if ((list.get(n).flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP))
            }*/


            for(PackageInfo pi : packageList) {
                boolean b = isSystemPackage(pi);
                boolean c = isSystemPackage1(pi);

                if(!b || !c ) {
                    packageList1.add(pi);
                }
            }

            //sort by application name

            final PackageItemInfo.DisplayNameComparator comparator = new PackageItemInfo.DisplayNameComparator(packageManager);

            Collections.sort(packageList1, new Comparator<PackageInfo>() {
                @Override
                public int compare(PackageInfo lhs, PackageInfo rhs) {
                    return comparator.compare(lhs.applicationInfo, rhs.applicationInfo);
                }
            });



            return null;
        }