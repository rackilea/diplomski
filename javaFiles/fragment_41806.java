final FutureTask<Object> ft = new FutureTask<Object>(() -> {}, new Object());
final Function<Boolean, ? extends Class<Void>> functionCallback = (Boolean t) -> {
    if(t) {
        plugin.setIsInstalled(Boolean.TRUE);
        ft.run();
    }
    return Void.TYPE;
};

foo.install(plugin,functionCallback); 
ft.get();
if(plugin.getIsInstalled().getValue())
    return "done";
else 
    return "not done";