@WebMethod
   public void myMethod(@XmlJavaTypeAdapter(ClassXAdapter.class)   ClassX arg0);

   @WebMethod
   @XmlJavaTypeAdapter(ClassXAdapter.class)
   public ClassX myMethod2();