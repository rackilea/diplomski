for (int i = 0; i < restaurant.length(); i++) {
        JSONObject c = restaurant.getJSONObject(i);

        String category = c.getString("category_id");
        if(category.equals("1"))
        {
            String item_name = c.getString(TAG_ITEM_NAME);
            String cuisine_name = c.getString(TAG_CUISINE_NAME);

            // tmp hashmap for single contact
            HashMap<String, String> contact = new HashMap<String, String>();

            // adding each child node to HashMap key => value
            contact.put(TAG_ITEM_NAME, item_name);
            contact.put(TAG_CUISINE_NAME, cuisine_name);


            // adding contact to contact list
            restaurantList.add(contact);
        }
    }