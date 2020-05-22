public void sizeOfInteger(){
    int size = SizeOfUtil.execute(new Instantiator(){
        @Override public Object execute() {
            return new Integer (3);
        }
    });
    System.out.println(Integer.class.getSimpleName() + " size = " + size + " bytes");
}