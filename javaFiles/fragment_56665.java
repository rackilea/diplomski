ArrayList<ServerDetails> servers = new ArrayList<ServerDetails>(){{
    add(new ServerDetails(10, "a"));
    add(new ServerDetails(40, "b"));
    add(new ServerDetails(20, "c"));
    add(new ServerDetails(30, "d"));
}}; 

ServerPool serverPool = new ServerPool();
serverPool.init(servers);
for (int i = 0; i < 10000; i++)
    System.out.println(serverPool.getNext().getAddress());