public static synchronized Desktop getDesktop(){
   //...
   Desktop desktop = (Desktop)context.get(Desktop.class);
    if (desktop == null) {
        desktop = new Desktop();
        context.put(Desktop.class, desktop);
    }
  //...
}