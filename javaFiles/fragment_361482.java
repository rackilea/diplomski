Future<?> f = pool.execute(p);

while(!f.isDone()) {
    // do something else, task not complete
}

f.get();