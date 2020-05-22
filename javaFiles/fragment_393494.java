public static void add(String key, DocumentObjectHolder obj){
        Queue<DocumentObjectHolder> priorityProcessingVirtualQueue= cacheData.get(key);
        if(priorityProcessingVirtualQueue== null){
             Queue<DocumentObjectHolder> temp = new PriorityQueue<DocumentObjectHolder>(1, new PriorityComparator());
             queue = cacheData.putIfAbsent(key, temp);
             if(priorityProcessingVirtualQueue== null){ 
                  priorityProcessingVirtualQueue= temp;
             } 
        }
        synchronized(priorityProcessingVirtualQueue){
            priorityProcessingVirtualQueue.add(obj);
        }
    }