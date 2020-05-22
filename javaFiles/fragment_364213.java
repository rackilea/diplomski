public AnnotationConfigApplicationContext init(){
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    try { 
        Class<DataPreProcessor> c= (Class<DataPreProcessor>) Class.forName("com.banamex.middleware.commons.DataPrepProcesorTest");
        Class<DataPreProcessor> c2= (Class<DataPreProcessor>) Class.forName("com.banamex.middleware.commons.DataPrepProcesorTest2");
         DataPreProcessor dp=c.newInstance();
        DataPreProcessor dp2=c2.newInstance();
        context.getBeanFactory().registerSingleton("c", dp);
        context.refresh();
    } catch (InstantiationException e) {

        e.printStackTrace();
    } catch (IllegalAccessException e) { 
        e.printStackTrace();
    } catch (ClassNotFoundException e) { 
        e.printStackTrace();
    } 
    return context;
}