public class AccountData extends JSONObject {

  private static final String TAG=AccountData.class.getSimpleName();

  private static final String ACOUNT_CARDS="SingleHomeCardItemList";

  public AccountData(String json) throws JSONException {
        super(json);
        }

        public AccountData(JSONObject json) throws JSONException {
            super(json.toString());
        }

        public ArrayList<SingleHomeCardItem> getAcountCards() throws JSONException {

            ArrayList<SingleHomeCardItem> cardsArray = new ArrayList<SingleHomeCardItem>();
            JSONArray cardsJSONArray = optJSONArray(ACOUNT_CARDS);


            if(!optString(ACOUNT_CARDS).equals("null")){
                 for(int i=0; i<cardsJSONArray.length(); i++) {
                        cardsArray.add(new          SingleHomeCardItem(cardsJSONArray.getString(i)));
                        }
            }

            return cardsArray;
            }