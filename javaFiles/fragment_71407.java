class Application {
    public static void main(String[] s){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
        ProjectServiceImpl service = applicationContext.getBean(ProjectServiceImpl.class);
    }
}