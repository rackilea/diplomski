public class StandardAnnotationMethodHandlerAdapter extends AnnotationMethodHandlerAdapter    {
    @Override
    protected ServletRequestDataBinder createBinder(HttpServletRequest request, Object target, String objectName) throws Exception {
    MyServletRequestDataBinder dataBinder = new MyServletRequestDataBinder(target, objectName);
    return dataBinder;
   }
}