for (int i = 0; i < Symptoms.get(0).size(); i++) {
        for (int j = 1; j < Symptoms.size(); j ++) {
            mapReflDayOneandTwo.put(Symptoms.get(j).get(0) + Symptoms.get(0).get(i), 
                 Symptoms.get(j).get(i + 1));
        }
   }