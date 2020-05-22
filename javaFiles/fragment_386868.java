public MyResponse getDataJSON(String response)
                    {
                        MyResponse myResponse = new MyResponse();
                        ArrayList<String> idList = new ArrayList<String>();
                        ArrayList<String> nombreList = new ArrayList<String>();
                        ArrayList<String> descList = new ArrayList<String>();
                        ArrayList<String> califList = new ArrayList<String>();

                        try
                        {
                            JSONArray jsonArray = new JSONArray(response);

                            for(int i=0; i<jsonArray.length(); i++)
                            {
                              idList.add(jsonArray.getJSONObject(i).getString("id"));

   nombreList.add(jsonArray.getJSONObject(i).getString("nombre"));
                              descList.add(jsonArray.getJSONObject(i).getString("descripcion"));
                              califList.add(jsonArray.getJSONObject(i).getString("calificacion"));
                            }

                            myResponse.setIdList(idList);
                            myResponse.setNombreList(nombreList);
                            myResponse.setDescList(descList);
                            myResponse.setCalifList(califList);

                            return myResponse;
                        }

                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }

                        return list;
                    }