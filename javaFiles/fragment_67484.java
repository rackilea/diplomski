State state02 = StatemachineFactoryImpl.eINSTANCE.createState();
state02.setName("bbbb");
region02.getState().add(state02);
if (state02.eResource() == null) {
    System.out.println("state02 NOT contained in resource!");
    return;
}