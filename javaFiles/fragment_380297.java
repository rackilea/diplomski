Method m = null;
try {
    m = Window.class.getDeclaredMethod("setLayersOpaque", Component.class, Boolean.TYPE);
    m.setAccessible(true);
    m.invoke(null, this, false);
} catch ( Exception e ) {
    //TODO: handle errors correctly
} finally {
    if ( m != null ) {
        m.setAccessible(false);
    }
}