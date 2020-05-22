HashMap<String, ArrayList<String>> m = new HashMap<>();
        Iterator<Map.Entry<String,ArrayList<String>>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String,ArrayList<String>> entry = iter.next();
            ArrayList<String> list = entry.getValue();
            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i).equals(cuvant)){
                    list.remove(i);
                }
            }
            if(list.isEmpty())
                iter.remove();
        }