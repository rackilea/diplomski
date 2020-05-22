class Application {
    public static void main(String[] s){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
        ProjectDAO dao = applicationContext.getBean(ProjectDAO.class);
    }
}