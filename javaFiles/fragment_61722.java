Map<Integer, List<Exchangeflows>> countryCodes = new HashMap<Integer, List<Exchangeflows>>();
       for(Entry<Exchangeflows,Integer> entry : CbExchangePower.entrySet()){
               List<Exchangeflows> list = new ArrayList<Exchangeflows>();
               if(countryCodes.containsKey(entry.getValue()))
                   list = countryCodes .get(entry.getValue());
               list.add(entry.getKey());
               countryCodes .put(entry.getValue(), list);
       }
       System.out.println(countryCodes);