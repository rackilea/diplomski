public void parsetheJson(String your_string_of_json){
     try {
            JSONArray mCountriesArray = new JSONArray(your_string_of_json);
            ArrayList<CountryDataModel> mCountryArray = new ArrayList<CountryDataModel>;
            for(int i = 0;i<mCountriesArray.length();i++){
                mCountryArray.add(mCountriesArray.getJSONObject(i));
         //this will give you an arraylist of all JSONobjects
         // then you have to do the same thing for the inner arrays
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }