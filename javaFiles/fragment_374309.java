stringRequest = new StringRequest(Request.Method.GET,
                url_all,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("movies");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                String name = o.getString("name");
                                String year = o.getString("year");
                                String genre = o.getString("genre");
                                String rating = o.getString("rating");
                                String director = o.getString("directors_name");
                                String actor = o.getString("cast");
                                String img_src = o.getString("poster_src");
                                String desc = o.getString("description");

                                m_name3.add(name);
                                m_release_year3.add(year);
                                m_genre3.add(genre);
                                m_rating3.add(rating);
                                m_director3.add(director);
                                m_actor3.add(actor);
                                m_imgsrc3.add(img_src);
                                m_desc3.add(desc);
                            }

                            Toast.makeText(msms.this, "Index: "+ m_name3.size(), Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Some error Occured", Toast.LENGTH_SHORT).show();
                    }
                });