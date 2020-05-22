Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
       for(int i = 1; i<cipher2.length(); i++ ){
            if(cipher2Array[i] == 'f') {
                arrayList.add(i);
                int jumpDistance = arrayList.get(i) - arrayList.get(i-1);
                Integer freq = counter.get(jumpdistance);
                freq = freq == null ? 1 : freq+1;
                counter.put(jumpDistance, freq);
            }
        }