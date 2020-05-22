try {
                    int total = 0;                         //  add this

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("cart");
                    for (int i = 0; i<array.length(); i++){
                        JSONObject o = array.getJSONObject(i);
                        CartItem item = new CartItem(
                                o.getString("cardno"),
                                o.getString("product_id"),
                                o.getString("name"),
                                o.getString("quantity"),
                                o.getString("price"),
                                o.getString("category")
                        );
                        cartItems.add(item);

                        //  add this
                        if(o.getString("price") != null &&
                           o.getString("price") != "" ){
                            total += Integer.parseInt(o.getString("price"));
                        }


                    }
                    adapter = new CartAdaptor(cartItems, getContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }