try {
    Class Addition = Class.forName("com.thirdparty.Addition");
    Object addition = Addition.newInstance();
    Method addMethod = Addition.getMethod("add", int.class, int.class);
    Integer sum = (Integer)addMethod.invoke(addition, 4, 5);
    System.out.println("The result is: " + sum);
    } catch (Throwable ex) {
        ex.printStackTrace();
        System.out.println("Addition is not available");
}