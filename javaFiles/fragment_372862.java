Producer5 producer = new Producer5(queue, maxCapacity);
    pool.execute(producer);
    pool.execute(producer);
    pool.execute(producer);
    pool.execute(producer);
    pool.execute(producer);