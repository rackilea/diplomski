private long getHeapCostFromMembers(String cacheName, Set<Member> members) throws Exception {
        long totalCacheHeapCost=0;
        members=hazelcastInstance.getCluster().getMembers();

       IExecutorService executorService = hazelcastInstance.getExecutorService("default");

       DistrubutedMapStats distrubutedMapStats=new DistrubutedMapStats(cacheName);
       distrubutedMapStats.setHazelcastInstance(hazelcastInstance);

       System.out.println("Total Members in Cloud="+members.size()); 
       Map<Member, Future<String>> futures = executorService.submitToMembers(distrubutedMapStats, members);
       int i=0;
       for (Future<String> future : futures.values())
       {
            i++;
            String heapCostFromMembers = future.get();

            System.out.println("HEAP COST "+"For Cache "+cacheName+" is"+" of Member="+i+" is "+heapCostFromMembers);

            if(!heapCostFromMembers.isEmpty())
            {
            totalCacheHeapCost+=Long.parseLong(heapCostFromMembers);
        }

            // ...
       }

        System.out.println("Total HEAP COST "+"For Cache "+cacheName+" is"+" of Members="+members.size()+" is "+totalCacheHeapCost);


    return totalCacheHeapCost;
    }