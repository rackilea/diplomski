Context mContext = null;

DashboardAdapter(Context context)
{
    mContext = context;
    dashboardImages = new ArrayList<DashboardItems>();
    Resources res = context.getResources();
    String[] tempDashItems = res.getStringArray(R.array.dashboard_names);
    int[] dashImages = {R.drawable.apartments, R.drawable.atms, R.drawable.banks, R.drawable.book_stores, R.drawable.car_rentals, R.drawable.furniture_shops, R.drawable.gas_stations, R.drawable.gyms, R.drawable.malls, R.drawable.mobile_shops, R.drawable.pharmacy, R.drawable.pizza_places, R.drawable.postal_services, R.drawable.restaurants, R.drawable.subs_burgers, R.drawable.supermarkets, R.drawable.theatres};
    for(int i=0;i<10;i++)
    {
        DashboardItems tempDash = new DashboardItems(dashImages[i],tempDashItems[i]);
        dashboardImages.add(tempDash);
    }
}