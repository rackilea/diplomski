OrderEntity[] a = new OrderEntity[q.size()];
    q.toArray(a);
    Arrays.sort(a, new OrderEntityComparator());

    for(OrderEntity entity : a)
        System.out.println(entity);