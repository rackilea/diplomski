// here we declare the Map before the "k" for loop        
                Map<Integer, ArrayList<Subitem_base_child>> ch_lists = new HashMap<Integer, ArrayList<Subitem_base_child>>();
                for (int k = 0; k < itemarry.length(); k++) {
                    ch_list = new ArrayList<Subitem_base_child>(); // here is the trick
                    JSONObject itmobj = itemarry.getJSONObject(k);
                    Subitem_base subitems = new Subitem_base();
                    subitems.setGroupitemname(itmobj.getString("BaseName"));
                    JSONArray subitemschildarray = itmobj.getJSONArray("subitems");
                    for (int j = 0; j < subitemschildarray.length(); j++) {
                        JSONObject subiteobj = subitemschildarray.getJSONObject(j);
                        Subitem_base_child subitembase = new Subitem_base_child();
                        subitembase.setChilditemname(subiteobj.getString("SubItemdesc"));
                        ch_list.add(subitembase);
                    }
                    ch_lists.put(k, ch_list);
                    subitems.setItems(ch_lists.get(k));
                    list.add(subitems);
                }