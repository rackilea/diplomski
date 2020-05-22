public class MyAnnotationRunner {
    public static void main(String[] args) {
        Field[] fields = MyInterface.class.getFields();
        for(Field field:fields){
            for(Annotation ann:field.getAnnotations()){
                if (ann instanceof MyAnnotation){
                    MyAnnotation my = (MyAnnotation)ann;
                    System.out.println(my.description());
                }
            }
        }
    }
}