JsonArrayRequest urunReq = new JsonArrayRequest(jsonUrl, new Response.Listener<JSONArray>()
    {
        @Override
        public void onResponse(JSONArray response)
        {
            String dosyakonum = "http://www.pukkaliving.concept.com/upload/galeri/buyuk/";
            hidePDialog();
            for (int i = 0; i < response.length(); i++)
            {
                try
                {

                    JSONObject obj = response.getJSONObject(i);
                    Urun urun = new Urun();
                    urun.setUrun_adi(obj.getString("urun_adi"));
                    urun.setUrl("http://www.iremdeveci.com/ornekler/resimler/resim.png");//example
                    urunList.add(urun);
                } catch (JSONException ex)
                {
                    ex.printStackTrace();
                }
            }
            adapter.notifyDataSetChanged();
        }
    }, new Response.ErrorListener()
    {
        @Override
        public void onErrorResponse(VolleyError volleyError)
        {
            Toast.makeText(getActivity(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
        }
    }) {
        @Override
        protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
            try {
                String jsonString =
                        new String(response.data, HttpHeaderParser.parseCharset(response.headers));

                long now = System.currentTimeMillis();
                Cache.Entry entry = HttpHeaderParser.parseCacheHeaders(response);
                entry.ttl = now + 30l * 24 * 60 * 60 * 1000;  //keeps cache for 30 days
entry.softTtl = now + 1 * 24 * 60 * 60 * 1000;  //will not try to refresh for 1 day     
                    return Response.success(new JSONArray(jsonString), entry);
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException je) {
                    return Response.error(new ParseError(je));
                }
            }
        };
        AppController.getmInstance().addToRequestQueue(urunReq);