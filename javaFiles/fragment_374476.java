try {
    InitialContext context = new InitialContext();           
    HelloBeanRemote helloBean =
        (HelloBeanRemote) context.lookup("java:global/MyEnterpriseApplication/MyEnterpriseApplication-ejb/HelloBean");
    System.out.println(helloBean.sayHello("Geziefer"));
} catch (NamingException ex) {          
}