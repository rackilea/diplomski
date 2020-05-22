public class ModelMenu implements Serializable {

    private String deleted, description, ingredients, inventory, menuItemID, name, paused, price, rating, restaurantID, servedEnd, servedStart, image;

    public ModelMenu() {
    }

    public ModelMenu(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public ModelMenu(String deleted, String description, String ingredients, String inventory, String menuItemID, String name, String paused, String price, String rating, String restaurantID, String servedEnd, String servedStart, String image) {
        this.deleted = deleted;
        this.description = description;
        this.ingredients = ingredients;
        this.inventory = inventory;
        this.menuItemID = menuItemID;
        this.name = name;
        this.paused = paused;
        this.price = price;
        this.rating = rating;
        this.restaurantID = restaurantID;
        this.servedEnd = servedEnd;
        this.servedStart = servedStart;
        this.image = image;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(String menuItemID) {
        this.menuItemID = menuItemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaused() {
        return paused;
    }

    public void setPaused(String paused) {
        this.paused = paused;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getServedEnd() {
        return servedEnd;
    }

    public void setServedEnd(String servedEnd) {
        this.servedEnd = servedEnd;
    }

    public String getServedStart() {
        return servedStart;
    }

    public void setServedStart(String servedStart) {
        this.servedStart = servedStart;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}







public class RestaurantFragment extends Fragment {

            private String title;
            private int page;
            private String restaurantId;
            private String menuItemCategoryID;

            private AdapterMenu mAdapter;
            private List<ModelMenu> menuList;

            TextView orderTimeTv, changeTimeTv, tenPercentTv, fifteenPercentTv, twentyPercentTv, customTipTv, totalTipTv, subTotalTv, taxTotalTv, totalTv, pickedTimeTv, pickedDateTv, todayTv, cancelTv, itemCountTv;
            ImageView fabCartIv;
            RecyclerView recyclerView;

            public RestaurantFragment() {
                // Required empty public constructor
            }

            // newInstance constructor for creating fragment with arguments
            /*public static RestaurantFragment newInstance(int page, String title, String restID, String menuItemCategoryID) {
                RestaurantFragment fragmentFirst = new RestaurantFragment();
                Bundle args = new Bundle();
                args.putInt("someInt", page);
                args.putString("someTitle", title);
                args.putString("restId", restID);
                args.putString("menuItemCategoryID", menuItemCategoryID);
                fragmentFirst.setArguments(args);
                return fragmentFirst;
            }*/

            public static RestaurantFragment newInstance(int page, String title, String restID, String menuItemCategoryID, List<ModelMenu> menuList) {
                RestaurantFragment fragmentFirst = new RestaurantFragment();
                Bundle args = new Bundle();
                args.putInt("someInt", page);
                args.putString("someTitle", title);
                args.putString("restId", restID);
                args.putString("menuItemCategoryID", menuItemCategoryID);
                args.putSerializable("menuList", (Serializable) menuList);
                fragmentFirst.setArguments(args);
                return fragmentFirst;
            }

            // Store instance variables based on arguments passed
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                page = getArguments().getInt("someInt", 0);
                title = getArguments().getString("someTitle");
                restaurantId = getArguments().getString("restId");
                menuItemCategoryID = getArguments().getString("menuItemCategoryID");
                menuList = (List<ModelMenu>) getArguments().getSerializable("menuList");
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                // Inflate the layout for this fragment
                View view = inflater.inflate(R.layout.fragment_restaurant, container, false);

                recyclerView = view.findViewById(R.id.menuRecyclerView);
                itemCountTv = view.findViewById(R.id.itemCountTv);
                fabCartIv = view.findViewById(R.id.fabCartIv);

                /*if (title.equals("Appetizers")) {
                    loadDataAppetizers();
                } else if (title.equals("Breakfast")) {
                    loadBreakfast();
                } else if (title.equals("Noodle")) {
                    loadNoodle();
                }*/
                loadMenuItems();

                fabCartIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showCartDialog();
                    }
                });

                count();
                return view;
            }

            private void loadMenuItems() {
                //recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                //Log.i("mytag", "list received with size: " + menuList.size() + ", in tab: " + title);
                mAdapter = new AdapterMenu(menuList, getActivity().getApplicationContext(), RestaurantFragment.this);
                recyclerView.setAdapter(mAdapter);
                /*String token = "auth" + System.currentTimeMillis();
                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                //show progress dialog
                progressDialog.setMessage("Getting Menu Items...");
                progressDialog.show();*/

                /*Map<String, String> params = new HashMap<>();
                params.put("Token", token);
                params.put("RestaurantID", restaurantId);
                Log.d("TheToken", Utils.getToken() + "" + Utils.getEmail());

                String url = ApiManager.headerUrl + ApiManager.menuItemsUrl;

                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        url, new JSONObject(params),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                //progressDialog.dismiss();
                                Log.d("TheResponse", response.toString());

                                try {
                                    JSONObject joResponse = response.getJSONObject("Response");
                                    JSONArray jaMainMenu = joResponse.getJSONArray("MainMenu");
                                    JSONArray jaMenuItemImages = joResponse.getJSONArray("MenuItemImages");
                                    JSONArray jaMenuCategories = joResponse.getJSONArray("MenuCategories");
                                    JSONArray jaLinkedMenuItems = joResponse.getJSONArray("LinkedMenuItems");
                                    JSONArray jaMenuSidesTitles = joResponse.getJSONArray("MenuSidesTitles");
                                    JSONArray jaMenuSidesLinks = joResponse.getJSONArray("MenuSidesLinks");
                                    JSONArray jaMenuSides = joResponse.getJSONArray("MenuSides");

                                    *//*for (int j = 0; j < jaMenuCategories.length(); j++) {
                                        String menuItemCategoryID = jaMainMenu.getJSONObject(j).getString("MenuItemCategoryID");
                                    }*//*

                                    for (int i = 0; i < jaLinkedMenuItems.length(); i++) {
                                        String menuItemCategoryID1 = jaLinkedMenuItems.getJSONObject(i).getString("MenuItemCategoryID");

                                        if (menuItemCategoryID.equals(menuItemCategoryID1)) {
                                            String menuItemID1 = jaLinkedMenuItems.getJSONObject(i).getString("MenuItemID");
                                            for (int j = 0; j < jaMainMenu.length(); j++) {
                                                String deleted = jaMainMenu.getJSONObject(j).getString("Deleted");
                                                String description = jaMainMenu.getJSONObject(j).getString("Description");
                                                String ingredients = jaMainMenu.getJSONObject(j).getString("Ingredients");
                                                String inventory = jaMainMenu.getJSONObject(j).getString("Inventory");
                                                String menuItemID = jaMainMenu.getJSONObject(j).getString("MenuItemID");
                                                String name = jaMainMenu.getJSONObject(j).getString("Name");
                                                String paused = jaMainMenu.getJSONObject(j).getString("Paused");
                                                String price = jaMainMenu.getJSONObject(j).getString("Price");
                                                String rating = jaMainMenu.getJSONObject(j).getString("Rating");
                                                String restaurantID = jaMainMenu.getJSONObject(j).getString("RestaurantID");
                                                String servedEnd = jaMainMenu.getJSONObject(j).getString("ServedEnd");
                                                String servedStart = jaMainMenu.getJSONObject(j).getString("ServedStart");
                                                String imageURL = jaMenuItemImages.getJSONObject(j).getString("ImageURL");
                                                if (menuItemID1.equals(menuItemID)) {
                                                    ModelMenu cModels = new ModelMenu("" + deleted,
                                                            "" + description,
                                                            "" + ingredients,
                                                            "" + inventory,
                                                            "" + menuItemID,
                                                            "" + name,
                                                            "" + paused,
                                                            "$" + price,
                                                            "" + rating,
                                                            "" + restaurantID,
                                                            "" + servedEnd,
                                                            "" + servedStart,
                                                            "" + imageURL);
                                                    menuList.add(cModels);
                                                }

                                            }
                                            //adapter to be set to recyclerview
                                            mAdapter = new AdapterMenu(menuList, getActivity().getApplicationContext(), RestaurantFragment.this);
                                            recyclerView.setAdapter(mAdapter);
                                        }


                                    }


                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //progressDialog.dismiss();
                        try {
                            if (error.getMessage().toLowerCase().contains("no address associated with hostname")) {

                            } else {

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                Volley.newRequestQueue(getActivity()).add(jsonObjReq);*/
            }

            private int tipPercentage = 10;
            private String date = "";

            //used to pass lists in confirm order
            private ArrayList idList = new ArrayList();
            private ArrayList nameList = new ArrayList();
            private ArrayList priceList = new ArrayList();
            int ids = 0;
            List<ModelMenu> menuList1;
            MyAdapters myAdapters;

            @SuppressLint("NewApi")
            private void showCartDialog() {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_cart, null);
                RecyclerView recyclerView = view.findViewById(R.id.menusLayout);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                menuList1 = new ArrayList<>();

                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(view);
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        tipPercentage = 10;
                        totalPriceAddRemove = 0.0;
                        idList.clear();
                        nameList.clear();
                        priceList.clear();
                        ids = 0;
                    }
                });
                builder.create().show();

                orderTimeTv = view.findViewById(R.id.orderTimeTv);
                changeTimeTv = view.findViewById(R.id.changeTimeTv);
                tenPercentTv = view.findViewById(R.id.tenPercentTv);
                fifteenPercentTv = view.findViewById(R.id.fifteenPercentTv);
                twentyPercentTv = view.findViewById(R.id.twentyPercentTv);
                customTipTv = view.findViewById(R.id.customTipTv);
                totalTipTv = view.findViewById(R.id.totalTipTv);
                subTotalTv = view.findViewById(R.id.subTotalTv);
                taxTotalTv = view.findViewById(R.id.taxTotalTv);
                totalTv = view.findViewById(R.id.totalTv);
                pickedTimeTv = view.findViewById(R.id.pickedTimeTv);
                pickedDateTv = view.findViewById(R.id.pickedDateTv);
                todayTv = view.findViewById(R.id.todayTv);
                cancelTv = view.findViewById(R.id.cancelTv);
                final Button checkoutBtn = view.findViewById(R.id.checkoutBtn);
                Button doneDTBtn = view.findViewById(R.id.doneDTBtn);
                final TimePicker timePicker = view.findViewById(R.id.timePicker);
                HorizontalCalendar hcCalendar = view.findViewById(R.id.hcCalendar);
                final LinearLayout dateTimePickLayout = view.findViewById(R.id.dateTimePickLayout);
                final RelativeLayout pricesLayout = view.findViewById(R.id.pricesLayout);

                dateTimePickLayout.setVisibility(View.GONE);
                pricesLayout.setVisibility(View.VISIBLE);

                EasyDB easyDB = EasyDB.init(getActivity(), "ITEMS_DB") // "TEST" is the name of the DATABASE
                        .setTableName("ITEMS_TABLE")  // You can ignore this line if you want
                        .addColumn(new Column("Item_Id", "text", "unique"))
                        .addColumn(new Column("Item_Name", "text", "not null"))
                        .addColumn(new Column("Item_Price", "text", "not null"))
                        .doneTableColumn();
                Cursor res = easyDB.getAllData();
                while (res.moveToNext()) {
                    String id = res.getString(1);
                    String name = res.getString(2);
                    String price = res.getString(3);
                    ModelMenu modelMenu = new ModelMenu("" + name, "" + price);
                    menuList1.add(modelMenu);
                    idList.add(ids);
                    nameList.add(name);
                    priceList.add(price);
                    ids++;
                }
                onAddField(getActivity());
                myAdapters = new MyAdapters(getActivity(), menuList1);
                recyclerView.setAdapter(myAdapters);

                timePicker.setIs24HourView(true);

                Calendar calendar = Calendar.getInstance();
                final int hours = calendar.get(Calendar.HOUR_OF_DAY);
                final int minute = calendar.get(Calendar.MINUTE);
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH) + 1;
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                date = day + "/" + month + "/" + year;

                pickedTimeTv.setText(hours + ":" + minute);
                pickedDateTv.setText(day + "/" + month + "/" + year);

                timePicker.setHour(hours);
                timePicker.setMinute(minute);

                timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                        pickedTimeTv.setText(hour + ":" + minute);
                    }
                });











 }