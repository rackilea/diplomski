public class Splash extends Activity {

    String bestsellerORoccassions;
    ArrayList<productDetails> categoryProductsData;
    ArrayList<productDetails> bestsellereData;
    ArrayList<productDetails> occassionsData;

    ArrayList<productDetails> bestsellerResult;
    ArrayList<productDetails> occassionResult;


    boolean internetConnection;
    private productAdapter productAdapter;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        bestsellerORoccassions = "";
        categoryProductsData = new ArrayList<>();
        bestsellereData = new ArrayList<>();
        occassionsData = new ArrayList<>();

        occassionResult = new ArrayList<>(); 
        bestsellerResult = new ArrayList<>();

        internetConnection = UtilityClass.isInternetAvailable(getApplicationContext());


        bestsellerORoccassions = "bestsellers";

        if (internetConnection) {

          occassionResult =  new getProductsTask().execute("41");
          bestsellerResult = new getProductsTask().execute("4");
        } else {
            Intent internet = new Intent(com.ecommerce.dell.ecommerce.Splash.this, NointernetConnection.class);
            startActivity(internet);
            finish();
        }
    }


    public class getProductsTask extends AsyncTask<String, Void, ArrayList<productDetails>> {


        JSONObject result = new JSONObject();
        JSONObject result1 = new JSONObject();
        String error = "";
        JsonFunctions jsonFunctions = new JsonFunctions();
        ArrayList<ArrayList<String>> return_products = new ArrayList<ArrayList<String>>();

        private ArrayList<productDetails> getProductsDataFromJSON(JSONObject productsJSONObj) throws JSONException {

            final String product_image = "image";
            final String product_name = "name";
            final String product_id = "id";
            final String productRealPrice = "price";
            final String getProductDiscount = "discount";
            final String getProductDescreiption = "description";
            final String getProductPercentage = "percentage";

            // *********  instantiate the list here  ***********
            ArrayList<productDetails> productDetailsArr = new ArrayList<productDetails>();
            JSONArray productsArray = productsJSONObj.getJSONArray("products");

            for (int i = 0; i < productsArray.length(); i++) {
                /*get JSON Object represent product info(Image-Name-Real Price - Discount)*/
                JSONObject getProductInfo = productsArray.getJSONObject(i);
                String pImage = getProductInfo.getString(product_image);
                String pName = getProductInfo.getString(product_name);
                String pID = getProductInfo.getString(product_id);
                String pRealPrice = getProductInfo.getString(productRealPrice);
                String pDiscount = getProductInfo.getString(getProductDiscount);
                String pDescreiption = getProductInfo.getString(getProductDescreiption);
                String pPercentage = getProductInfo.getString(getProductPercentage);
                productDetailsArr.add(i, new productDetails(pName, pID, pRealPrice, pDiscount, pDescreiption, pImage, pPercentage));
            }
            Log.d("ProductDetails", "Product Details: ");
            for (int i = 0; i < productDetailsArr.size(); i++) {
                Log.d("ProductDetails", "Product Details: " + productDetailsArr.get(i).getProductID());
            }

            return productDetailsArr;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //  progressDialog.show();
            Log.d("getProductsTask", "getProductsTask");
        }

        @Override
        protected ArrayList<productDetails> doInBackground(String... params) {
            result = jsonFunctions.getCategoryProducts(params[0], String.valueOf(0));


            if (result == null) {
                error = "null json object";
                return null;
            }
            try {
                if (result.getInt("success") == 1) {
                    return getProductsDataFromJSON(result);
                }
            } catch (Exception ex) {
                error = ex.toString();
                Log.d("getProductsTask", error);

            }
            return null;

        }

        @Override
        protected void onPostExecute(ArrayList<productDetails> products) {
            super.onPostExecute(products);




        }


    }


    @Override
    protected void onStop() {
        super.onStop();


    }
}