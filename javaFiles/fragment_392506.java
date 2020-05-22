public void onEnable(){
    //if the code above is in your main file, use this:
    this.getServer().getPluginManager().registerEvents(this, this);

    //if it's in another class, use this:
    this.getServer().getPluginManager().registerEvents(new myClassNameHere(), this);
}