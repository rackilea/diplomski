@Override
public FF4j getFF4j() {
    final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(FF4j.class); 
    context.refresh();

    FF4j ff4j= context.getBean(FF4j.class);
    return ff4j;
}