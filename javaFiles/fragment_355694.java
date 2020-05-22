ArrayList<ArrayList<HashMap<String, String>>> hashMapArrayList1 = new ArrayList<>();
ArrayList<HashMap<String, String>> hashMapArrayList2 = new ArrayList<>();
    for (int i = 0; i < yourlist.size(); i++) {
          try {
                HashMap<String, String> hs = new HashMap<>();
                hs.put("question_id", "" + yourlist.get(i).getQueId().trim());
                hs.put("option_id", "" + yourlist.get(i).getOptionId().trim());                
                hashMapArrayList2.add(hs);
          } catch (Exception e) {
                e.printStackTrace();
          }
        }
      hashMapArrayList1.add(hashMapArrayList2);
      paramas.put("quiz_data", hashMapArrayList1);