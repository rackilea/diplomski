JSONArray jsonarray = new JSONArray(json);

                for (int i = 0; i < jsonarray.length(); i++) 
                {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String tmp = jsonobject.getString("desagg");

                    if(!tmp.equals("0"))//vuol dire che dessagg diverso da 0
                    {
                        String sql2="select group_concat(descri) from memodocu where pointm="+tmp+" group by pointm;";
                        ResultSet rs = db.executeQuery(sql2);
                        String tmp2="";

                        while(rs.next())
                        {
                            tmp2=rs.getString("group_concat(descri)");
                        }
                        jsonobject.put("desArticolo", tmp2);
                    }