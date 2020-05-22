HashMap<Integer, Runnable> map = new HashMap<Integer, Runnable>();
map.put(Register.ID, new Runnable() { 
    public void run() { functionA(); }
});
map.put(NotifyMessage.ID, new Runnable() { 
    public void run() { functionB(); }
});
// ...
map.get(id).run();