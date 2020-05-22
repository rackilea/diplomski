try {
        JSONObject obj = new JSONObject(loadJSONFromAsset());
        JSONArray m_jArry = obj.getJSONArray("formules");
        ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> m_li;

        for (int i = 0; i < m_jArry.length(); i++) {
            JSONObject jo_inside = m_jArry.getJSONObject(i);
            Log.d("Details-->", jo_inside.getString("formule"));
            String formula_value = jo_inside.getString("formule");
            String url_value = jo_inside.getString("url");

            //Add your values in your `ArrayList` as below:
            m_li = new HashMap<String, String>();
            m_li.put("formule", formula_value);
            m_li.put("url", url_value);

            formList.add(m_li);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }