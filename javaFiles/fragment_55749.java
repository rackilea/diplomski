String[] arr1 = new String[hashmap.size()];
String[] arr2 = new String[hashmap.size()];
        Set entries = hashmap.entrySet();
        Iterator entriesIterator = entries.iterator();

        int i = 0;
        while(entriesIterator.hasNext()){

            Map.Entry mapping = (Map.Entry) entriesIterator.next();

            arr1[i] = mapping.getKey().toString();
            arr2[i] = mapping.getValue().toString();

            i++;
        }