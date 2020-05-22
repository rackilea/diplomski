for(int i=0; i<46; i++){
            try {
                JSONObject jsonObject   =   new JSONObject(<string to be parsed>);
                String first            =   jsonObject.getString(Integer.toString(i));
                JSONObject jsonObject1  =   new JSONObject(first);
                String country          =   jsonObject1.getString("county");
                System.out.println("country="+country);
                String cod              =   jsonObject1.getString("coords");
                JSONObject jsonObject2  =   new JSONObject(cod);
                String lat              =   jsonObject2.getString("lat");
                System.out.println("lat="+lat);
                String lng              =   jsonObject2.getString("lng");
                System.out.println("lng="+lng);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }