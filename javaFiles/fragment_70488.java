public static void main(String[] args) {
Child1 c1 = new Child1("child1Config1", "child1Config2");
Child1 c11 = new Child1("child1Config11", "child1Config22");

Child1 c2 = new Child1("child2Config1", "child2Config2");
Child1 c22 = new Child1("child2Config11", "child2Config22");

System.out.println("Parent object c1- config1" + c1.getInstance().getConfig1());

System.out.println("Parent object c1- config2" + c1.getInstance().getConfig2());

System.out.println("Parent object c11- config1" + c11.getInstance().getConfig1());

System.out.println("Parent object c11- config2" + c11.getInstance().getConfig2());

System.out.println("Parent object c2- config1" + c2.getInstance().getConfig1());

System.out.println("Parent object c2- config2" + c2.getInstance().getConfig2());

System.out.println("Parent object c22- config1" + c22.getInstance().getConfig1());

System.out.println("Parent object c22- config2" + c22.getInstance().getConfig2());

System.out.println("Parent Object c1- parentInstance: " + c1.getInstance());

System.out.println("Parent Object c11- parentInstance: " + c11.getInstance());

System.out.println("Parent Object c2- parentInstance: " + c2.getInstance());

System.out.println("Parent Object c22- parentInstance: " + c22.getInstance());
}