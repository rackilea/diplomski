public static void main( String[] args )
  {
    ApplicationContext context = new AnnotationConfigApplicationContext( Context.class );
    Single single = context.getBean( Single.class );
    single.useBean();
    single.useBean();
  }