Iterator i1 = listOperateur.iterator();
    for (Map.Entry<Integer, ArrayList<Integer>> e : hmm.entrySet()) {
       //if (e.getValue() != null) {
            count = 0;
            //you can move this part to another method to avoid deep nested code
            for (Integer mapValue : e.getValue()) {
                // for (Integer listValue : listOperateur) {
                if (mapValue.equals(listOperateur.get(k))) {
                    count++;
                    //  }
                }
            }
            sim.put(e.getKey(), count);
            k++;
      //  }
    }