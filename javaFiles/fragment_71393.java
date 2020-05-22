database_connector wp_terms = new database_connector("SELECT * FROM  `dse120071750`.`wp_terms` ",progressDialog,this);
wp_terms.setCallback(new Runnable() {

        public void run() {

        try {

                for (int i=0; i<wp_terms.getJsonArray().length(); i++){
                    JSONObject obj = wp_terms.getJsonArray().getJSONObject(i);
                    this.wp_terms.put(obj.getString("term_id"),      obj.getString("name"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    });
    wp_terms.execute();