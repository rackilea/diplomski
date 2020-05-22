class abstract ScaleProvider {

  ScaleProvider getInstance() {
    String className = ScaleProvider.class.getName() + "Impl";
    try {
      Class<?> implClass = ScaleProvider.class.getClassLoader().loadClass( className );
      return ( ScaleProvider )implClass.newInstance();
    } catch( ClassNotFoundException | InstantiationException | IllegalAccessException e ) {
      throw new RuntimeException( e );
    }
  }

  abstract float getScale( Gc gc );
}