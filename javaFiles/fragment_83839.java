public class RestaurantAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Restaurant> restaurants;
    private Context context;
    private SharedData sharedData;

    private final int FIRST_OPEN_RESTAURANT = 0;
    private final int OPEN_RESTAURANT = 1;

    public RestaurantAdapter(List<Restaurant> restaurantsList) {
        restaurants = restaurantsList;
        sharedData = SharedData.getInstance();
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.i("getItemVi(position)", "position=" + position);
        //If position is 0 this means we need to use FirstOpenRestaurantVHolder
        if (position == 0) {
            return 0;

        } else if (position > 0) {
            return 1;
        }


        return 1; //TODO ojo con este default
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.i("onCreateVewHo(viewType)", "viewType=" + viewType);

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        if (viewType == 0) {
            View firstOpenRest = inflater.inflate(R.layout.intro_home_restaurant_first_card, viewGroup, false);
            viewHolder = new FirstOpenRestaurantVHolder(firstOpenRest);

        } else {
            View openRestaurant = inflater.inflate(R.layout.intro_home_resturant_card_row, viewGroup, false);
            viewHolder = new OpenRestaurantsViewHolder(openRestaurant);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewholder, int position) {
        Log.i("onBindViewHolder", "viewholder.getItemViewType()=" + viewholder.getItemViewType());

        if (viewholder.getItemViewType() == 0) {
            FirstOpenRestaurantVHolder firstVH = (FirstOpenRestaurantVHolder) viewholder;
            firstVH.franchiseName.setText("FIRST!!!");

        } else {
            OpenRestaurantsViewHolder openVH = (OpenRestaurantsViewHolder) viewholder;
            openVH.franchiseName.setText("OPEN BUT NOT FIRST");

        }
    }

    public class OpenRestaurantsViewHolder extends RecyclerView.ViewHolder {

        protected TextView franchiseName;
        protected TextView homeCategory;
        protected ImageView restaurantPhoto;
        protected ImageView franchiseLogo;


        public OpenRestaurantsViewHolder(View view) {
            super(view);
            franchiseName = (TextView) view.findViewById(R.id.home_franchise_name);
            restaurantPhoto = (ImageView) view.findViewById(R.id.home_resturant_pic);
            franchiseLogo = (ImageView) view.findViewById(R.id.home_franchise_logo);
            homeCategory = (TextView) view.findViewById(R.id.home_category);

        }
    }

    public class FirstOpenRestaurantVHolder extends RecyclerView.ViewHolder {

        protected TextView franchiseName;
        protected TextView homeCategory;
        protected ImageView restaurantPhoto;
        protected ImageView franchiseLogo;


        public FirstOpenRestaurantVHolder(View view) {
            super(view);

            franchiseName = (TextView) view.findViewById(R.id.home_first_franchise_name);
            restaurantPhoto = (ImageView) view.findViewById(R.id.home_first_resturant_pic);
            franchiseLogo = (ImageView) view.findViewById(R.id.home_first_franchise_logo);
            homeCategory = (TextView) view.findViewById(R.id.home_first_category);
        }


    }
}