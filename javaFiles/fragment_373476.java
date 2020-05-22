try {
                        JSONArray jsonArray=response.getJSONArray("server_responce");
                        for (int i=0;i<=jsonArray.length();i++){

                            JSONObject admin=jsonArray.getJSONObject(i);
                            String bno = admin.getString("bno");
                            String series=admin.getString("sno");
                            if (bnum.equals(bno)) {
                                int k = Integer.valueOf(series);
                                solution.add(k);
                            }

                        }