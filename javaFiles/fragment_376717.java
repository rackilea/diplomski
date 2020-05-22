public static void main(String[] args) {
    ZooKeeper zoo;
    try {
        zoo = new ZooKeeper("localhost:2182", 5000, null);
        Gson gson = new GsonBuilder().registerTypeAdapter(ClientCnxn.class, new ClientCnxnAdapter()).create() ;
        String json = gson.toJson(zoo);
        System.out.println(json); //---->{"cnxn":{"sessionId":0,"timeOut":0},"watchManager":{"dataWatches":{},"existWatches":{},"childWatches":{}}}
    } catch (Exception e) {
        e.printStackTrace();
    }
}