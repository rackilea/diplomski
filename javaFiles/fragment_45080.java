Collection<ChannelFuture> futures = ArrayList<ChannelFuture>();
...
 //here you add your futures
 ChannelFuture f = connectWithHandler(identity.get("ip").getAsString(), identity.get("port").getAsInt(), handlers); 
 futures.add(f);
...

DefaultChannelGroupFuture groupOfFutures = new DefaultChannelGroupFuture(futures, executor);
if (groupOfFutures.sync().isSuccess()) {
}