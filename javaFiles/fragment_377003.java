new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("products");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);
                                qst = new Question();
                                String option1 = employee.getString("option1");
                                qst.id=employee.getInt("id");
                                qst.option1=employee.getString("option1");
                                qst.option2=employee.getString("option2");
                                qst.vote1=employee.getInt("vote1");
                                qst.vote2=employee.getInt("vote2");
                                boolean added =  Questions.add(qst);
                                if (added)
                                {
                                    texto1.append("added\n");
                                } else
                                {
                                    texto1.append("not added\n");
                                }

                            }
                            for (int i = 0; i < Questions.size(); i++) {
                                texto1.append("option " + Questions.get(i).option1 + "\n");
                            }
                            texto1.append(" size "+Questions.size()); //here i get size of 2
                            //Collections.shuffle(Questions);

                            LoadQst(); // Call here.
                        } catch (JSONException e) {
                            e.printStackTrace();
                            texto1.setText(e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }